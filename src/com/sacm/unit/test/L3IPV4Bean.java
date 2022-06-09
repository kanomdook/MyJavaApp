package com.sacm.unit.test;

public class L3IPV4Bean {

	private String ip;
	private String subnet;
	private String sequence;
	
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getSubnet() {
		return subnet;
	}
	public void setSubnet(String subnet) {
		this.subnet = subnet;
	}
	public String getSequence() {
		return sequence;
	}
	public void setSequence(String sequence) {
		this.sequence = sequence;
	}
	@Override
	public String toString() {
		return "L3IPV4bean [ip=" + ip + ", subnet=" + subnet + ", sequence=" + sequence + "]";
	}
}
