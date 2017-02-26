package org.tool.manage.features;

import java.util.ArrayList;
import java.util.List;

import org.tool.manage.features.model.BundleModel;

public class BundlesUtils {

    List<BundleModel> featureBundlesNo1 = new ArrayList<BundleModel>();
    List<BundleModel> featureBundlesNo2 = new ArrayList<BundleModel>();

    public BundlesUtils(List<BundleModel> featureBundlesNo1,
	    List<BundleModel> featureBundlesNo2) {
	super();
	this.featureBundlesNo1 = featureBundlesNo1;
	this.featureBundlesNo2 = featureBundlesNo2;
    }

    public List<BundleModel> getFeatureBundlesNo1() {
	return featureBundlesNo1;
    }

    public void setFeatureBundlesNo1(List<BundleModel> featureBundlesNo1) {
	this.featureBundlesNo1 = featureBundlesNo1;
    }

    public List<BundleModel> getFeatureBundlesNo2() {
	return featureBundlesNo2;
    }

    public void setFeatureBundlesNo2(List<BundleModel> featureBundlesNo2) {
	this.featureBundlesNo2 = featureBundlesNo2;
    }
    
    public void countAndDisplayBundelsNumber(){
	System.out.println("Feature No1 : " + featureBundlesNo1.size() + ", Feature No2 : " + featureBundlesNo2.size());
    }
    
    
    //prikazati uporedjivanje bundle koje nedostaku jedno u drugome 
    
    //prikazivanje verzija ako se ne poklapaju verzije 
    
    // prikazivanje ...

}
