package com.dookdev.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestAlarm {
	
	@JsonProperty("RuleName")
	private String RuleName;
	private String system;
	private String emsIp;
	private String manager;
	private String domain;
	private String neType;
	private String region;
	private String amoName;
	private String alertName;
	private String severity;
	private String description;
	private String col1;
	private String col2;
	private String col3;
	private String col4;
	private String col5;
	private String col6;
	private String col7;
	private String col8;
	private String col9;
	private String col10;
	private String col11;
	private String col12;
	private String col13;
	private String col14;
	private String col15;
	private String alarmTime;
	private String node;
	private String sitecode;
	private String vendor;
	private String serverserial;
	private String deviceIp;
	private String reserve1;
	private String reserve2;
	private String reserve3;
	private String reserve4;
	private String reserve5;

	public String getRuleName() {
		return RuleName;
	}

	public void setRuleName(String ruleName) {
		RuleName = ruleName;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public String getEmsIp() {
		return emsIp;
	}

	public void setEmsIp(String emsIp) {
		this.emsIp = emsIp;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getNeType() {
		return neType;
	}

	public void setNeType(String neType) {
		this.neType = neType;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getAmoName() {
		return amoName;
	}

	public void setAmoName(String amoName) {
		this.amoName = amoName;
	}

	public String getAlertName() {
		return alertName;
	}

	public void setAlertName(String alertName) {
		this.alertName = alertName;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

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

	public String getCol3() {
		return col3;
	}

	public void setCol3(String col3) {
		this.col3 = col3;
	}

	public String getCol4() {
		return col4;
	}

	public void setCol4(String col4) {
		this.col4 = col4;
	}

	public String getCol5() {
		return col5;
	}

	public void setCol5(String col5) {
		this.col5 = col5;
	}

	public String getCol6() {
		return col6;
	}

	public String getCol7() {
		return col7;
	}

	public void setCol7(String col7) {
		this.col7 = col7;
	}

	public String getCol8() {
		return col8;
	}

	public void setCol8(String col8) {
		this.col8 = col8;
	}

	public String getCol9() {
		return col9;
	}

	public void setCol9(String col9) {
		this.col9 = col9;
	}

	public String getCol10() {
		return col10;
	}

	public void setCol10(String col10) {
		this.col10 = col10;
	}

	public String getCol11() {
		return col11;
	}

	public void setCol11(String col11) {
		this.col11 = col11;
	}

	public String getCol12() {
		return col12;
	}

	public void setCol12(String col12) {
		this.col12 = col12;
	}

	public String getCol13() {
		return col13;
	}

	public void setCol13(String col13) {
		this.col13 = col13;
	}

	public String getCol14() {
		return col14;
	}

	public void setCol14(String col14) {
		this.col14 = col14;
	}

	public String getCol15() {
		return col15;
	}

	public void setCol15(String col15) {
		this.col15 = col15;
	}

	public void setCol6(String col6) {
		this.col6 = col6;
	}

	public String getAlarmTime() {
		return alarmTime;
	}

	public void setAlarmTime(String alarmTime) {
		this.alarmTime = alarmTime;
	}

	public String getNode() {
		return node;
	}

	public void setNode(String node) {
		this.node = node;
	}

	public String getSitecode() {
		return sitecode;
	}

	public void setSitecode(String sitecode) {
		this.sitecode = sitecode;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getServerserial() {
		return serverserial;
	}

	public void setServerserial(String serverserial) {
		this.serverserial = serverserial;
	}

	public String getDeviceIp() {
		return deviceIp;
	}

	public void setDeviceIp(String deviceIp) {
		this.deviceIp = deviceIp;
	}

	public String getReserve1() {
		return reserve1;
	}

	public void setReserve1(String reserve1) {
		this.reserve1 = reserve1;
	}

	public String getReserve2() {
		return reserve2;
	}

	public void setReserve2(String reserve2) {
		this.reserve2 = reserve2;
	}

	public String getReserve3() {
		return reserve3;
	}

	public void setReserve3(String reserve3) {
		this.reserve3 = reserve3;
	}

	public String getReserve4() {
		return reserve4;
	}

	public void setReserve4(String reserve4) {
		this.reserve4 = reserve4;
	}

	public String getReserve5() {
		return reserve5;
	}

	public void setReserve5(String reserve5) {
		this.reserve5 = reserve5;
	}

	@Override
	public String toString() {
		return "RequestAlarm [RuleName=" + RuleName + ", system=" + system
				+ ", emsIp=" + emsIp + ", manager=" + manager + ", domain="
				+ domain + ", neType=" + neType + ", region=" + region
				+ ", amoName=" + amoName + ", alertName=" + alertName
				+ ", severity=" + severity + ", description=" + description
				+ ", col1=" + col1 + ", col2=" + col2 + ", col3=" + col3
				+ ", col4=" + col4 + ", col5=" + col5 + ", col6=" + col6
				+ ", col7=" + col7 + ", col8=" + col8 + ", col9=" + col9
				+ ", col10=" + col10 + ", col11=" + col11 + ", col12=" + col12
				+ ", col13=" + col13 + ", col14=" + col14 + ", col15=" + col15
				+ ", alarmTime=" + alarmTime + ", node=" + node + ", sitecode="
				+ sitecode + ", vendor=" + vendor + ", serverserial="
				+ serverserial + ", deviceIp=" + deviceIp + ", reserve1="
				+ reserve1 + ", reserve2=" + reserve2 + ", reserve3="
				+ reserve3 + ", reserve4=" + reserve4 + ", reserve5="
				+ reserve5 + "]";
	}
	
}
