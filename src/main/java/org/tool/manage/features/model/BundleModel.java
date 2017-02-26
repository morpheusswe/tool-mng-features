package org.tool.manage.features.model;

public class BundleModel {

//    private int maxSpace;
    private String type;
    private String groupId;
    private String artifactId;
    private String version;

    public BundleModel(String type, String groupId, String artifactId,
	    String version) {
	super();
	this.type = type;
	this.groupId = groupId;
	this.artifactId = artifactId;
	this.version = version;
//	countMaxSpace();
    }

    public String getType() {
	return type;
    }

    public void setType(String type) {
	this.type = type;
    }

    public String getGroupId() {
	return groupId;
    }

    public void setGroupId(String groupId) {
	this.groupId = groupId;
    }

    public String getArtifactId() {
	return artifactId;
    }

    public void setArtifactId(String artifactId) {
	this.artifactId = artifactId;
    }

    public String getVersion() {
	return version;
    }

    public void setVersion(String version) {
	this.version = version;
    }

//    private void countMaxSpace() {
//	this.maxSpace =  type.length();
//	if (groupId.length() > this.maxSpace) {
//	    this.maxSpace = groupId.length();
//	}
//
//	if (artifactId.length() > this.maxSpace) {
//	    this.maxSpace = artifactId.length();
//	}
//
//	if (version.length() < this.maxSpace) {
//	    this.maxSpace = version.length();
//	}
//
//    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result
		+ ((artifactId == null) ? 0 : artifactId.hashCode());
	result = prime * result + ((groupId == null) ? 0 : groupId.hashCode());
	result = prime * result + ((type == null) ? 0 : type.hashCode());
	result = prime * result + ((version == null) ? 0 : version.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	BundleModel other = (BundleModel) obj;
	if (artifactId == null) {
	    if (other.artifactId != null)
		return false;
	} else if (!artifactId.equals(other.artifactId))
	    return false;
	if (groupId == null) {
	    if (other.groupId != null)
		return false;
	} else if (!groupId.equals(other.groupId))
	    return false;
	if (type == null) {
	    if (other.type != null)
		return false;
	} else if (!type.equals(other.type))
	    return false;
	if (version == null) {
	    if (other.version != null)
		return false;
	} else if (!version.equals(other.version))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "BundleModel [type=" + type + ", groupId=" + groupId
		+ ", artifactId=" + artifactId + ", version=" + version + "]";
    }

}
