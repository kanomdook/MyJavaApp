package com.dookdev.beans;

public class VASNodeInfo {
	public String name;
	public String ip;
	public String port;
	public String user;
	public String password;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "VASNodeInfo [name=" + name + ", ip=" + ip + ", port=" + port + ", user=" + user + ", password="
				+ password + "]";
	}
}
