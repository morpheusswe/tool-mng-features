package org.tool.manage.features;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.karaf.features.BundleInfo;
import org.apache.karaf.features.internal.model.Feature;
import org.apache.karaf.features.internal.model.Features;
import org.apache.karaf.features.internal.model.JaxbUtil;
import org.apache.karaf.features.internal.service.FeatureValidationUtil;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(final String[] args) {
        System.out.println("Hello World!");

        // final Class clazz = App.class;
        // final InputStream inputStream = clazz.getResourceAsStream("/fileTest.txt");
        testCommnad1();

        final URL rootURL = ClassLoader.getSystemResource("././");
        System.out.println("Root URL : " + rootURL);

        // Load the directory as a resource
        final URL pomFileURL = ClassLoader.getSystemResource("pom-files/pom.xml");
        System.out.println("Url: " + pomFileURL.toString());
        // Turn the resource into a File object
        File pomFile = null;
        try {
            pomFile = new File(pomFileURL.toURI());
        } catch (final URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        parsePomXml(pomFile);

        // TEST
        final URL featureFileURL = ClassLoader.getSystemResource("pom-files/feature.xml");
        try {
            FeatureValidationUtil.validate(featureFileURL.toURI());
        } catch (final URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (final Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        parseFeature();

    }

    public static void moveToRoot() {
        try {
            Runtime.getRuntime().exec("ls -aF");
        } catch (final IOException e) {
            System.err.println(e);
        }
    }

    public static void testCommnad() {
        String s;
        Process p;
        try {
            p = Runtime.getRuntime().exec("ls -aF");
            final BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((s = br.readLine()) != null) {
                System.out.println("line: " + s);
            }
            p.waitFor();
            System.out.println("exit: " + p.exitValue());
            p.destroy();
        } catch (final Exception e) {
        }
    }

    public static void testCommnad1() {
        String s;
        Process p;
        try {
            p = Runtime.getRuntime().exec("pwd");
            final BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((s = br.readLine()) != null) {
                System.out.println("line: " + s);
            }
            p.waitFor();
            System.out.println("exit: " + p.exitValue());
            p.destroy();
        } catch (final Exception e) {
        }
    }

    public static Model parsePomXml(final File pomfile) {

        Reader reader = null;
        Model model = null;
        try {
            reader = new FileReader(pomfile);
            final MavenXpp3Reader xpp3Reader = new MavenXpp3Reader();
            model = xpp3Reader.read(reader);
        } catch (final FileNotFoundException e) {
            System.err.println(e);
        } catch (final IOException e) {
            System.err.println(e);
        } catch (final XmlPullParserException e) {
            System.err.println(e);
        } finally {
            try {
                reader.close();
            } catch (final IOException e) {
                System.err.println(e);
            }
        }

        return model;
    }

    public static void parseFeature() {
        // final InputStream in = getClass().getClassLoader().getResourceAsStream("input-features-1.1.0.xml");
        final URL featureFileURL = ClassLoader.getSystemResource("pom-files/feature.xml");
        Features featuresRoot = null;
        try {
            featuresRoot = JaxbUtil.unmarshal(featureFileURL.toURI().toString(), false);
        } catch (final URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        final List<Feature> featuresList = featuresRoot.getFeature();

        final Map<String, List<String>> features = new HashMap<String, List<String>>();

        for (final Feature feature : featuresList) {

            final String futureName = feature.getName();
            // System.out.println("Feature : " + feature);
            final List<String> bundles = new ArrayList<String>();
            for (final BundleInfo bundleInfo : feature.getBundles()) {
                bundles.add(bundleInfo.getLocation());
                // System.out.println("Bundle info: " + bundleInfo.getLocation());
            }
            features.put(futureName, bundles);
        }

        final List<String> bundle = features.get("cots-service");
        for (final String string : bundle) {
            final String formatedBundleLocation = string.replace("mvn:", "");
            final String[] budleProps = formatedBundleLocation.split("/");

            final String groupId = budleProps[0];
            final String artifactId = budleProps[1];
            final String version = budleProps[2];

            System.out.println("GID : " + groupId + ", AID : " + artifactId + ", V : " + version);
        }

        // for (final Feature feature : featuresList) {
        // System.out.println("Feature : " + feature.getId());
        // for (final Dependency dependency : feature.getFeature()) {
        // System.out.println("dependency info: " + dependency.getName());
        // }
        // }

    }

    // private static String
    //
    // readFromInputStream(final InputStream inputStream) throws IOException {
    // final StringBuilder resultStringBuilder = new StringBuilder();
    // try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
    // String line;
    // while ((line = br.readLine()) != null) {
    // resultStringBuilder.append(line).append("\n");
    // }
    // }
    // return resultStringBuilder.toString();
    // }
}
