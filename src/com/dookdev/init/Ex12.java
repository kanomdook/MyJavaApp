package com.dookdev.init;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex12 {

	public static void main(String[] args) {
		String cmdRes1 = "PHY: Physical\r\n" + 
				"*down: administratively down\r\n" + 
				"#down: LBDT down\r\n" + 
				"(l): loopback\r\n" + 
				"(s): spoofing\r\n" + 
				"(b): BFD down\r\n" + 
				"(e): ETHOAM down\r\n" + 
				"(dl): DLDP down\r\n" + 
				"(lb): LBDT block\r\n" + 
				"Interface                     PHY     Protocol Description\r\n" + 
				"GE0/0/1                       up      up       Ngerntidlor_Klaeng_Corporate WiFi:9000119116\r\n" + 
				"GE0/0/2                       *down   down\r\n" + 
				"GE0/0/3                       *down   down\r\n" + 
				"GE0/0/4                       *down   down\r\n" + 
				"GE0/0/5                       down    down     CONNECT-(HUAWEI)50YMLM:GE0/0/1\r\n" + 
				"GE0/0/6                       down    down     CONNECT-(HUAWEI)50YMLM:GE0/0/1\r\n" + 
				"GE0/0/7                       down    down     CONNECT-(HUAWEI)50YMLM:GE0/0/1\r\n" + 
				"GE0/0/8                       down    down     CONNECT-(HUAWEI)50YMLM:GE0/0/1\r\n" + 
				"GE0/0/9                       down    down     CONNECT-(HUAWEI)50YMLM:GE0/0/1\r\n" + 
				"GE0/0/10                      down    down     CONNECT-(HUAWEI)50YMLM:GE0/0/1\r\n" + 
				"GE0/0/11                      down    down     CONNECT-(HUAWEI)50YMLM:GE0/0/1\r\n" + 
				"GE0/0/12                      down    down     CONNECT-(HUAWEI)50YMLM:GE0/0/1\r\n" + 
				"GE0/0/13                      down    down     CONNECT-(HUAWEI)50YMLM:GE0/0/1\r\n" + 
				"GE0/0/14                      down    down     CONNECT-(HUAWEI)50YMLM:GE0/0/1\r\n" + 
				"GE0/0/15                      down    down     CONNECT-(HUAWEI)50YMLM:GE0/0/1\r\n" + 
				"GE0/0/16                      down    down     CONNECT-(HUAWEI)50YMLM:GE0/0/1\r\n" + 
				"GE0/0/17                      down    down     CONNECT-(HUAWEI)50YMLM:GE0/0/1\r\n" + 
				"GE0/0/18                      down    down     CONNECT-(HUAWEI)50YMLM:GE0/0/1\r\n" + 
				"GE0/0/19                      down    down     CONNECT-(HUAWEI)50YMLM:GE0/0/1\r\n" + 
				"GE0/0/20                      down    down     CONNECT-(HUAWEI)50YMLM:GE0/0/1\r\n" + 
				"GE0/0/21                      down    down     CONNECT-(HUAWEI)50YMLM:GE0/0/1\r\n" + 
				"GE0/0/22                      down    down     CONNECT-(HUAWEI)50YMLM:GE0/0/1\r\n" + 
				"GE0/0/23                      down    down     CONNECT-(HUAWEI)50YMLM:GE0/0/1\r\n" + 
				"GE0/0/24                      down    down     CONNECT-(HUAWEI)50YMLM:GE0/0/1\r\n" + 
				"GE0/0/25                      down    down\r\n" + 
				"GE0/0/26                      down    down\r\n" + 
				"GE0/0/27                      up      up       UP-TRUNK-ONT\r\n" + 
				"GE0/0/28                      down    down\r\n" + 
				"NULL0                         up      up(s)\r\n" + 
				"Vlanif1                       up      down\r\n" + 
				"Vlanif132                     up      up       \"Management Switch\"\r\n" + 
				"Vlanif501                     up      up       9000119116\r\n" + 
				"Vlanif611                     up      up       Service_WiFi\r\n" + 
				"Vlanif782                     up      up       LAN-Service";
		
		
		
		String cmdRes2 = "PHY: Physical\r\n" + 
				"*down: administratively down\r\n" + 
				"#down: LBDT down\r\n" + 
				"(l): loopback\r\n" + 
				"(s): spoofing\r\n" + 
				"(b): BFD down\r\n" + 
				"(e): ETHOAM down\r\n" + 
				"(dl): DLDP down\r\n" + 
				"(lb): LBDT block\r\n" + 
				"Interface                     PHY     Protocol Description\r\n" + 
				"GE0/0/1                       up      up       Ngerntidlor_Klaeng_Corporate WiFi\\r\\n"
				+ ":9000119116\r\n" + 
				"GE0/0/2                       *down   down\r\n" + 
				"GE0/0/3                       *down   down\r\n" + 
				"GE0/0/4                       *down   down\r\n" + 
				"GE0/0/5                       down    down     CONNECT-(HUAWEI)50YMLM:GE0/0/1\r\n" + 
				"GE0/0/6                       down    down     CONNECT-(HUAWEI)50YMLM:GE0/0/1\r\n" + 
				"GE0/0/7                       down    down     CONNECT-(HUAWEI)50YMLM:GE0/0/1\r\n" + 
				"GE0/0/8                       down    down     CONNECT-(HUAWEI)50YMLM:GE0/0/1\r\n" + 
				"GE0/0/9                       down    down     CONNECT-(HUAWEI)50YMLM:GE0/0/1\r\n" + 
				"GE0/0/10                      down    down     CONNECT-(HUAWEI)50YMLM:GE0/0/1\r\n" + 
				"GE0/0/11                      down    down     CONNECT-(HUAWEI)50YMLM:GE0/0/1\r\n" + 
				"GE0/0/12                      down    down     CONNECT-(HUAWEI)50YMLM:GE0/0/1\r\n" + 
				"GE0/0/13                      down    down     CONNECT-(HUAWEI)50YMLM:GE0/0/1\r\n" + 
				"GE0/0/14                      down    down     CONNECT-(HUAWEI)50YMLM:GE0/0/1\r\n" + 
				"GE0/0/15                      down    down     CONNECT-(HUAWEI)50YMLM:GE0/0/1\r\n" + 
				"GE0/0/16                      down    down     CONNECT-(HUAWEI)50YMLM:GE0/0/1\r\n" + 
				"GE0/0/17                      down    down     CONNECT-(HUAWEI)50YMLM:GE0/0/1\r\n" + 
				"GE0/0/18                      down    down     CONNECT-(HUAWEI)50YMLM:GE0/0/1\r\n" + 
				"GE0/0/19                      down    down     CONNECT-(HUAWEI)50YMLM:GE0/0/1\r\n" + 
				"GE0/0/20                      down    down     CONNECT-(HUAWEI)50YMLM:GE0/0/1\r\n" + 
				"GE0/0/21                      down    down     CONNECT-(HUAWEI)50YMLM:GE0/0/1\r\n" + 
				"GE0/0/22                      down    down     CONNECT-(HUAWEI)50YMLM:GE0/0/1\r\n" + 
				"GE0/0/23                      down    down     CONNECT-(HUAWEI)50YMLM:GE0/0/1\r\n" + 
				"GE0/0/24                      down    down     CONNECT-(HUAWEI)50YMLM:GE0/0/1";
		
		String cmdRes3 = "GE0/0/1                       up      up       Ngerntidlor_Klaeng_Corporate WiFi                                               :9000119116";
		
//		ArrayList<String> result = getPortHuawei(cmdRes);
//		
//		System.out.println(">>> result size: " + result.size());
//		
//		System.out.println(result.toString());
		
		String cmdRes = cmdRes3;
		
		String regex = "ge([0-9]+\\/[0-9]+\\/[0-9]+).*wi.*|ge([0-9]+\\/[0-9]+\\/[0-9]+).*\n.*wi.*";
		ArrayList<String> portList = new ArrayList<String>();
		Pattern pattern;
		Matcher matcher;
		pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
		cmdRes = cmdRes.trim();
		cmdRes = cmdRes.replaceAll("\r", "");
		String[] s = cmdRes.split("\n", -1);
		if (s != null) {
			for (int i = 0; i < s.length; i++) {
				String data = s[i].trim();
				matcher = pattern.matcher(data);
				if(matcher.find()) {
					if(!portList.contains(matcher.group(1))){
						portList.add(matcher.group(1));
					}
				}
			}
		}
		
		System.out.println(">>> portList size: " + portList.size());
		
		System.out.println(portList.toString());
		
		

	}
	
	public static ArrayList<String> getPortHuawei(String response){
		String regex = "ge([0-9]+\\/[0-9]+\\/[0-9]+).*wi.*|ge([0-9]+\\/[0-9]+\\/[0-9]+).*\n.*wi.*";//(GE[0-9]\/[0-9]\/[0-9])(.*WiFi.*)
		ArrayList<String> portList = new ArrayList<String>();
		Pattern pattern;
		Matcher matcher;
		
		pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
		response =  response.replaceAll("\r\n", "\n");
		String data[] =  response.split("\n",-1);
		for(int i = 0; i < data.length; i+=2) {
			if(i<data.length-1) {
				matcher = pattern.matcher(data[i]+data[i+1]);
				if(matcher.find()) {
					if(!portList.contains(matcher.group(1))){
						portList.add(matcher.group(1));
					}
				}
			}
		}
		return portList;
	}

}
