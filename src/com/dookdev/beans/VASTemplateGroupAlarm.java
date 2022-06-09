package com.dookdev.beans;

import java.util.LinkedList;

public class VASTemplateGroupAlarm {
    private String col1;
    private String col2;
    private String alertName;
    private String amoName;
    private String description;
    private String jumpHost;
    private LinkedList<String> nodeKey;
    
	public String getCol1() {
		return col1;
	}
	public void setCol1(String col1) {
		this.col1 = col1;
	}
	public String getCol2() {
		return col2;
	}
	public void setCol2(String col2) {
		this.col2 = col2;
	}
	public String getAlertName() {
		return alertName;
	}
	public void setAlertName(String alertName) {
		this.alertName = alertName;
	}
	public String getAmoName() {
		return amoName;
	}
	public void setAmoName(String amoName) {
		this.amoName = amoName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getJumpHost() {
		return jumpHost;
	}
	public void setJumpHost(String jumpHost) {
		this.jumpHost = jumpHost;
	}
	public LinkedList<String> getNodeKey() {
		return nodeKey;
	}
	public void setNodeKey(LinkedList<String> nodeKey) {
		this.nodeKey = nodeKey;
	}

	@Override
	public String toString() {
		return "VASTemplateGroupAlarm [col1=" + col1 + ", col2=" + col2 + ", alertName=" + alertName + ", amoName="
				+ amoName + ", description=" + description + ", jumpHost=" + jumpHost + ", nodeKey=" + nodeKey + "]";
	}
}
