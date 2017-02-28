package org.tool.manage.features;

import org.tool.manage.features.model.BundleModel;
import org.tool.manage.features.model.FeatureModel;

public class FeatureUtils {
    
    private static final String TAB = "     "; 
    private static final String BORDER = "|";
    
    private FeatureModel f1;
    private FeatureModel f2;

    public FeatureUtils(FeatureModel f1, FeatureModel f2) {
	super();
	this.f1 = f1;
	this.f2 = f2;
    }
    
    public void display(){
	
	int maxDiplayField = TAB.length() + f1.getMaxWidthArtifactField() + TAB.length() + BORDER.length();
	for (BundleModel b : f1.getBundles()) {
	    StringBuffer sb = new StringBuffer();
	    int maxCurrenFieldWidth = TAB.length() + b.getArtifactId().length() + TAB.length() + BORDER.length();
	    int neededSpace = maxDiplayField -maxCurrenFieldWidth;
	    sb.append(TAB).append(b.getArtifactId()).append(createSpaceByGivenAmount(neededSpace)).append(TAB).append(BORDER);
	    System.out.println(sb.toString());
	}
    }
    
    private String  createSpaceByGivenAmount(int amount){
	StringBuffer sb =  new StringBuffer();
	for (int i = 0; i < amount; i++) {
	    sb.append(" ");
	}
	return  sb.toString();
    }
    
    
    
    
    

}
