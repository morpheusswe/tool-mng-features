package org.tool.manage.features;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.Writer;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.apache.maven.model.io.xpp3.MavenXpp3Writer;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;

public class ManipulateWithPom {

    public static void main(final String[] args) throws URISyntaxException {

	final URL rootURL = ClassLoader.getSystemResource("././");
	System.out.println("Root URL : " + rootURL);

	final URL pomFileURL = ClassLoader
		.getSystemResource("test-dir/pom.xml");
	System.out.println("Url: " + pomFileURL.toString());

	InputStream is = ClassLoader
		.getSystemResourceAsStream("test-dir/pom.xml");

	File pomFile = null;
	try {
	    pomFile = new File(is);
	} catch (final URISyntaxException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	final URL newPomFileURL = ClassLoader
		.getSystemResource("test-dir/pom_1.xml");
	File newPomFile = null;
	try {
	    newPomFile = new File(newPomFileURL.toURI());
	} catch (final URISyntaxException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	Model model = parsePomXml(pomFile);

	System.out.println("MOdel : " + model.getGroupId());

	model.setUrl("http://xxx.com");

	saveNewPomXml(newPomFile, model);

    }

    public static String findFeatureFileName(URI uri, String featureName) {
	final File folder = new File(uri);

	String fileName = null;
	for (final File fileEntry : folder.listFiles()) {
	    if (!fileEntry.isDirectory()) {
		System.out.println(fileEntry.getName());
		if (fileEntry.getName().startsWith(featureName)
			&& fileEntry.getName().endsWith(".xml")) {
		    fileName = fileEntry.getName();
		}
	    }
	}
	return fileName;
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

    public static Model saveNewPomXml(final File pomfile, Model model) {

	Writer writer = null;
	try {
	    writer = new FileWriter(pomfile);
	    MavenXpp3Writer xpp3Writer = new MavenXpp3Writer();
	    xpp3Writer.write(writer, model);
	} catch (final FileNotFoundException e) {
	    System.err.println(e);
	} catch (final IOException e) {
	    System.err.println(e);
	} finally {
	    try {
		writer.close();
	    } catch (final IOException e) {
		System.err.println(e);
	    }
	}

	return model;
    }

    // Example
    // String baseDir = "/your/project/basedir/";
    //
    // //Reading
    // MavenXpp3Reader reader = new MavenXpp3Reader();
    // Model model = reader.read(new FileInputStream(new File(baseDir,
    // "/pom.xml")));
    //
    // //Editing
    // model.setUrl("http://stackoverflow.com");
    //
    // //Writing
    // MavenXpp3Writer writer = new MavenXpp3Writer();
    // writer.write(new FileOutputStream(new File(baseDir, "/pom.xml")), model);
    // Example

}
