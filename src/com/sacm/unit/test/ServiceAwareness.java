package com.sacm.unit.test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ServiceAwareness {

	public static void main(String[] args) {
//		addL3IPv4();
//		addL3Host();
		addRuleL3();
//		newRG();
	}
	
	public static void addL3IPv4() {
		try {
			System.out.println(">>> ServiceAwareness addL3IPv4 <<<");
			String brandName = "Huawei5G UPF";
			String appName = "tiktok";
			String ipList = "163.171.156.64|28|1,163.171.162.32|28|2,49.231.62.108|30|3";
			System.out.println("> Brand Name: " + brandName);
			System.out.println("> App Name: " + appName);
			System.out.println("> IP range/subnet/sequence: " + ipList);
			List<L3IPV4Bean> dataList = setL3IPV4BeanList(ipList);
			if(brandName.equalsIgnoreCase("Huawei5G UPF")) {
				for (L3IPV4Bean dataL3IPV4 : dataList) {
					System.out.println(">>> "+ dataL3IPV4);
					String addfilter = String.format(SACMCommand.L3IPV4.UPF.ADD_FILTER, appName,dataL3IPV4.getSequence(), dataL3IPV4.getIp(), dataL3IPV4.getSubnet());
					String addflowfilter = String.format(SACMCommand.L3IPV4.UPF.ADD_FLOWFILTER, appName);
					String addfltbindflowf = String.format(SACMCommand.L3IPV4.UPF.ADD_FLTBINDFLOWF, appName,appName, dataL3IPV4.getSequence());
					String refresh = String.format(SACMCommand.L3IPV4.UPF.REFRESH);
					
					System.out.println(addfilter);
					System.out.println(addflowfilter);
					System.out.println(addfltbindflowf);
					System.out.println(refresh);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void addL3Host() {
		try {
			System.out.println(">>> ServiceAwareness addL3Host <<<");
			String brandName = "Huawei5G UPF";
			String appName = "wetv";
			String domainList = "midas.gtimg.cn|1,vm.gtimg.cn|2";
			System.out.println("> Brand Name: " + brandName);
			System.out.println("> App Name: " + appName);
			System.out.println("> Domain/Sequence: " + domainList);
			 List<L3HostBean> dataList = setL3HostBeanList(domainList);
			if(brandName.equalsIgnoreCase("Huawei5G UPF")) {
				for (L3HostBean dataL3Host : dataList) {
					System.out.println(">>> "+ dataL3Host);
					String domain =dataL3Host.getDomain();
					String sequence=dataL3Host.getSequence();
					String addfilter1 = String.format(SACMCommand.L3HOST.UPF.ADD_HOST, appName,sequence, domain);
					String addfilter2 = String.format(SACMCommand.L3HOST.UPF.ADD_FILTER, appName,sequence, appName, sequence);
					String addfilter3 = String.format(SACMCommand.L3HOST.UPF.ADD_FILTERIPV6, appName,sequence, appName, sequence);
					String addfilter4 = String.format(SACMCommand.L3HOST.UPF.ADD_FLOWFILTER, appName);
					String addfilter5 = String.format(SACMCommand.L3HOST.UPF.ADD_L34FILTERGROUP, appName,appName, sequence);
					String addfilter6 = String.format(SACMCommand.L3HOST.UPF.ADD_L34FILTERGROUP_IPV6,appName, appName, sequence);
					String refresh = String.format(SACMCommand.L3HOST.UPF.REFRESH);
					
					System.out.println(addfilter1);
					System.out.println(addfilter2);
					System.out.println(addfilter3);
					System.out.println(addfilter4);
					System.out.println(addfilter5);
					System.out.println(addfilter6);
					System.out.println(refresh);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void addRuleL3() {
		try {
			System.out.println(">>> ServiceAwareness addRuleL3 <<<");
			String brandName = "Huawei5G SMF";
			String appName = "youtube";
			String speed = "7m";
			String rg = "2387";
			String priority = "2300";
			System.out.println("> Brand Name: " + brandName);
			System.out.println("> App Name: " + appName);
			System.out.println("> speed: " + speed);
			System.out.println("> rg: " + rg);
			System.out.println("> priority: " + priority);
			if (brandName.equalsIgnoreCase("Huawei5G SMF")) {
				System.out.println(">>> ADD RULE");
				String cmd1 = String.format(SACMCommand.RULEL3.ADD_RULE.SMF.ADD_RULE1, appName,speed, priority, rg);
				String cmd2 = String.format(SACMCommand.RULEL3.ADD_RULE.SMF.ADD_RULE2, appName,speed, priority);
				System.out.println(cmd1);
				System.out.println(cmd2);
				
				System.out.println(">>> ADD RBN/Binding Rule");
				String cmd3 = String.format(SACMCommand.RULEL3.ADD_RBN.SMF.ADD_RBN, appName);
				String cmd4 = String.format(SACMCommand.RULEL3.ADD_RBN.SMF.SET_RBN_USER, appName);
				String cmd5 = String.format(SACMCommand.RULEL3.ADD_RBN.SMF.ADD_RBN_USER, appName,appName, speed);
				System.out.println(cmd3);
				System.out.println(cmd4);
				System.out.println(cmd5);
			} else if (brandName.equalsIgnoreCase("Huawei5G UPF")) {
				System.out.println(">>> ADD RULE");
				String cmd1 = String.format(SACMCommand.RULEL3.ADD_RULE.UPF.ADD_RULE1, appName,speed, appName, priority, rg);
				String cmd2 = String.format(SACMCommand.RULEL3.ADD_RULE.UPF.ADD_RULE2, appName,speed, appName, priority, rg);
				String cmd3 = String.format(SACMCommand.RULEL3.ADD_RULE.UPF.BLACKLISTRULE, appName,speed, appName, priority);
				String cmd4 = String.format(SACMCommand.RULEL3.ADD_RULE.UPF.REFRESH);
				System.out.println(cmd1);
				System.out.println(cmd2);
				System.out.println(cmd3);
				System.out.println(cmd4);

				System.out.println(">>> ADD RBN/Binding Rule");
				String cmd5 = String.format(SACMCommand.RULEL3.ADD_RBN.UPF.ADD_RBN, appName);
				String cmd6 = String.format(SACMCommand.RULEL3.ADD_RBN.UPF.LCK_USER, appName);
				String cmd7 = String.format(SACMCommand.RULEL3.ADD_RBN.UPF.ADD_RBN_PCC, appName,appName, speed);
				String cmd8 = String.format(SACMCommand.RULEL3.ADD_RBN.UPF.ADD_RBN_BWM, appName,appName, speed);
				String cmd9 = String.format(SACMCommand.RULEL3.ADD_RBN.UPF.ADD_RBN_HEADEN, appName,appName, speed);
				String cmd10 = String.format(SACMCommand.RULEL3.ADD_RBN.UPF.REFRESH);
				System.out.println(cmd5);
				System.out.println(cmd6);
				System.out.println(cmd7);
				System.out.println(cmd8);
				System.out.println(cmd9);
				System.out.println(cmd10);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void newRG() {
		try {
			System.out.println(">>> ServiceAwareness newRG <<<");
			String brandName = "Huawei5G UPF";
			String rg = "2387";
			System.out.println("> Brand Name: " + brandName);
			System.out.println("> rg: " + rg);
			if (brandName.equalsIgnoreCase("Huawei5G SMF")) {
				String cmd1 = String.format(SACMCommand.NEWRG.SMF.ADD_RG1, rg,rg,rg,rg);
				String cmd2 = String.format(SACMCommand.NEWRG.SMF.ADD_RG2, rg,rg,rg);
				String cmd3 = String.format(SACMCommand.NEWRG.SMF.ADD_RG3, rg,rg);
				System.out.println(cmd1);
				System.out.println(cmd2);
				System.out.println(cmd3);
			} else if (brandName.equalsIgnoreCase("Huawei5G UPF")) {
				String cmd1 = String.format(SACMCommand.NEWRG.UPF.ADD_RG1, rg,rg);
				String cmd2 = String.format(SACMCommand.NEWRG.UPF.ADD_RG2, rg,rg,rg);
				String cmd3 = String.format(SACMCommand.NEWRG.UPF.ADD_RG3, rg,rg);
				String cmd4 = String.format(SACMCommand.NEWRG.UPF.REFRESH);
				System.out.println(cmd1);
				System.out.println(cmd2);
				System.out.println(cmd3);
				System.out.println(cmd4);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static List<L3IPV4Bean> setL3IPV4BeanList(String data)throws Exception {
		List<L3IPV4Bean> dataL3IPV4List = new ArrayList<L3IPV4Bean>();
		List<String> dataList = new ArrayList<String>();
		String[] dataSplit = data.split(",");
		if (dataSplit.length > 0) {
			for (int i = 0; i < dataSplit.length; i++) {
				dataList.add(dataSplit[i]);
			}
		} else {
			dataList.add(data);
		}

		for (String d : dataList) {
			L3IPV4Bean dataL3IPV4 = new L3IPV4Bean();
			String[] dataSpit = d.split("\\|");
			if (dataSpit.length == 3) {
				if (isValidIPAddress(dataSpit[0])&&isValidNumber(dataSpit[1])&&isValidNumber(dataSpit[2])) {
					dataL3IPV4.setIp(dataSpit[0]);
					dataL3IPV4.setSequence(dataSpit[1]);
					dataL3IPV4.setSubnet(dataSpit[2]);
					dataL3IPV4List.add(dataL3IPV4);
				} else {
					System.out.println("data not format please check format \"IP|subnet|sequence\"\n");
					dataL3IPV4List.clear();
					break;
				}
			} else {
				System.out.println("data not format please check format \"IP|subnet|sequence\"\n");
			}
		}
		return dataL3IPV4List;

	}
	
	public static boolean isValidIPAddress(String ip) throws Exception {
		final String IPV4_PATTERN = "^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
		Matcher m1 = Pattern.compile(IPV4_PATTERN, Pattern.CASE_INSENSITIVE).matcher(ip);
		return m1.matches();
	}
	public static boolean isValidDomain(String domain) throws Exception {
		final String IPV4_PATTERN = "([a-zA-Z0-9]*\\.[a-zA-Z0-9]*\\.[a-zA-Z0-9]*)";
		Matcher m1 = Pattern.compile(IPV4_PATTERN, Pattern.CASE_INSENSITIVE).matcher(domain);
		return m1.matches();
	}

	public static boolean isValidNumber(String number) throws Exception {
		final String TYPE_NUM = "^([+-]?([0-9]*))$";
		Matcher m1 = Pattern.compile(TYPE_NUM, Pattern.CASE_INSENSITIVE).matcher(number);
		return m1.matches();
	}
	
	public static List<L3HostBean> setL3HostBeanList(String data) throws Exception {
		List<String> dataList = new ArrayList<String>();
		List<L3HostBean> dataL3HostList = new ArrayList<L3HostBean>();

		String[] dataSplit = data.split(",");
		if (dataSplit.length > 0) {
			for (int i = 0; i < dataSplit.length; i++) {
				dataList.add(dataSplit[i]);
			}
		} else {
			dataList.add(data);
		}
		for (String d : dataList) {
			L3HostBean dataL3Host = new L3HostBean();
			String[] dataSpit = d.split("\\|");
			if (dataSpit.length == 2) {
				if (isValidDomain(dataSpit[0]) && isValidNumber(dataSpit[1])) {
					dataL3Host.setDomain(dataSpit[0]);
					dataL3Host.setSequence(dataSpit[1]);
					dataL3HostList.add(dataL3Host);
				} else {
					System.out.println("data not format please check format \"Domain|Sequence\"\n");
					dataL3HostList.clear();
					break;
				}
			} else {
				System.out.println("data not format please check format \"Domain|Sequence\"\n");
			}
		}
		return dataL3HostList;
	}

}
