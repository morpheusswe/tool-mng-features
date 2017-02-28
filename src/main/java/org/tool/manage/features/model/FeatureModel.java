package org.tool.manage.features.model;

import java.util.ArrayList;
import java.util.List;

public class FeatureModel {
    
    private int maxWidthArtifactField=0;
    private int maxWidthGroupField=0;
    private int maxWidthVersionField=0;
    
    
    List<BundleModel> bundles = new ArrayList<BundleModel>();
    
    public FeatureModel(List<BundleModel> bundles) {
	super();
	this.bundles = bundles;
	initMaxWidthFields();	
    }
    
    private void initMaxWidthFields(){
	if(this.bundles != null && !this.bundles.isEmpty()){
	    for (BundleModel bundleModel : bundles) {
		if(maxWidthArtifactField < bundleModel.getArtifactId().length()){
		    this.maxWidthArtifactField = bundleModel.getArtifactId().length(); 
		}
		
		if(maxWidthGroupField < bundleModel.getGroupId().length()){
		    this.maxWidthGroupField = bundleModel.getGroupId().length(); 
		}
		
		if(maxWidthVersionField < bundleModel.getVersion().length()){
		    this.maxWidthVersionField = bundleModel.getVersion().length(); 
		}
	    }
	}
    }

    public List<BundleModel> getBundles() {
        return bundles;
    }

    public void setBundles(List<BundleModel> bundles) {
        this.bundles = bundles;
    }

    public int getMaxWidthArtifactField() {
        return maxWidthArtifactField;
    }

    public int getMaxWidthGroupField() {
        return maxWidthGroupField;
    }

    public int getMaxWidthVersionField() {
        return maxWidthVersionField;
    }
    
    
    
    
    
    
    

}
