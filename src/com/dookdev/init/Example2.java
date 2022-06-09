package com.dookdev.init;

import java.io.File;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

import org.apache.commons.lang3.ArrayUtils;

import com.dookdev.beans.VASNodeInfo;

public class Example2 {

	public static void main(String[] args) {
		Hashtable<String, VASNodeInfo> allVASNodeInfo = getAllVASNodeInfo();
		System.out.println("=========================Test Get Result========================");
		VASNodeInfo nodeInfo = allVASNodeInfo.get("PINSSMFRA201G");
		System.out.println(nodeInfo);
		System.out.println("=========================Test Get Result By Field===============");
		if(nodeInfo != null) {
			System.out.println("name: "+ nodeInfo.getName());
			System.out.println("ip: "+ nodeInfo.getIp());
			System.out.println("port: "+ nodeInfo.getPort());
			System.out.println("user: "+ nodeInfo.getUser());
			System.out.println("password: "+ nodeInfo.getPassword());
		}
		
	}
	
	public static Hashtable<String, VASNodeInfo> getAllVASNodeInfo() {
		Hashtable<String, VASNodeInfo> nodeList = new Hashtable<String, VASNodeInfo>();
		try {
			File file = new File("./vas/Node.txt");
			Scanner scanner = new Scanner(file);
			String content = "";
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				if (!line.equalsIgnoreCase("")) {
					content += line.trim() + "\n";
				}
			}
			String[] nodeContents = content.split("\n");
			String[] nodeHeadersSplit = null;
			for (int i = 0; i < nodeContents.length; i++) {
				if (i == 0) {
					nodeHeadersSplit = nodeContents[i].split(",");
				} else {
					VASNodeInfo nodeInfo = new VASNodeInfo();
					String nodeName = "";
					String[] nodeInfoSplit = nodeContents[i].split("\\|");
					for (int j = 0; j < nodeHeadersSplit.length; j++) {
						int index = ArrayUtils.indexOf(nodeHeadersSplit, nodeHeadersSplit[j]);
						if (index >= 0 && index <= (nodeInfoSplit.length - 1)) {
							String val = nodeInfoSplit[index].trim();
							String headder = nodeHeadersSplit[j].trim();
							if ("Node Name".equalsIgnoreCase(headder)) {
								nodeName = val;
								nodeInfo.setName(val);
							} else if ("Node Ip".equalsIgnoreCase(headder)) {
								nodeInfo.setIp(val);
							} else if ("Port".equalsIgnoreCase(headder)) {
								nodeInfo.setPort(val);
							} else if ("User".equalsIgnoreCase(headder)) {
								nodeInfo.setUser(val);
							} else if ("Passwd".equalsIgnoreCase(headder)) {
								nodeInfo.setPassword(val);
							}
						}
					}
					nodeList.put(nodeName, nodeInfo);
				}
			}
			scanner.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Enumeration<String> keys = nodeList.keys();
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			System.out.println("Value of " + key + " is: " + nodeList.get(key));
		}
		return nodeList;
	}

}
