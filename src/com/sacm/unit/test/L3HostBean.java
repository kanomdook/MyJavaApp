package com.sacm.unit.test;

public class L3HostBean {

	private String domain;
	private String sequence;
	

	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getSequence() {
		return sequence;
	}
	public void setSequence(String sequence) {
		this.sequence = sequence;
	}
	@Override
	public String toString() {
		return "L3IPV4bean [domain=" + domain + ", sequence=" + sequence + "]";
	}
}
