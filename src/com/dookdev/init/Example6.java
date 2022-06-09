package com.dookdev.init;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Example6 {
	public static void main(String[] args) {
		String message = " XXX_BKK_CHECK_MODEL_SWITCH_{IP}_{YYYYMMDD_HH24MI}.dat \r\n" + 
				" yyyyy_BKK_CHECK_MODEL_SWITCH_{IP}_{YYYYMMDD_HH24MI}.dat \r\n" + 
				"xxxxxxxx \r\n" + 
				" IF-MIB::ifName.49 = STRING: gi1\r\n" + 
				"IF-MIB::ifName.50 = STRING: gi2\r\n" + 
				"IF-MIB::ifName.51 = STRING: gi3\r\n" + 
				"IF-MIB::ifName.52 = STRING: gi4\r\n" + 
				"IF-MIB::ifName.53 = STRING: gi5\r\n" + 
				"SNMPv2-SMI::ifName.53 = STRING: gi5\r\n" + 
				" SNMPv2-SMI::ifName.53 = STRING: gi5\r\n" + 
				"HUAWEI_BKK_CHECK_MODEL_SWITCH_{IP}_{YYYYMMDD_HH24MI}.dat ";
		
		message = "No Response from 127.0.0.1 \\r\\n";
		
		final Pattern pattern = Pattern.compile(
				"IF-MIB");
		Matcher matcher = pattern.matcher(message);
//		System.out.println(matcher.matches());
		System.out.println(Pattern.compile("").matcher(message).find());
//		String[] statProcessList = {"MD-2021000037", "MD-2021000037", "MD-2021000037", "MD-2021000037", "MD-2021000037", "MD-2021000037", "MD-2021000037", "MD-2021000037", "MD-2021000037", "MD-2021000037"};
//		for (int i = 0; i < statProcessList.length; i++) {
//			System.out.println(statProcessList[i]);
//		}
	}

//	public static void main(String[] args) {
//		String message = " XXX_BKK_CHECK_MODEL_SWITCH_{IP}_{YYYYMMDD_HH24MI}.dat \r\n" + 
//				" yyyyy_BKK_CHECK_MODEL_SWITCH_{IP}_{YYYYMMDD_HH24MI}.dat \r\n" + 
//				"xxxxxxxx \r\n" + 
//				" IF-MIB::ifName.49 = STRING: gi1\r\n" + 
//				"IF-MIB::ifName.50 = STRING: gi2\r\n" + 
//				"IF-MIB::ifName.51 = STRING: gi3\r\n" + 
//				"IF-MIB::ifName.52 = STRING: gi4\r\n" + 
//				"IF-MIB::ifName.53 = STRING: gi5\r\n" + 
//				"SNMPv2-SMI::ifName.53 = STRING: gi5\r\n" + 
//				" SNMPv2-SMI::ifName.53 = STRING: gi5\r\n" + 
//				"HUAWEI_BKK_CHECK_MODEL_SWITCH_{IP}_{YYYYMMDD_HH24MI}.dat ";
//		StringBuilder sb = new StringBuilder();
//		message = message.trim();
//		message = message.replaceAll("\r", "");
//		String[] s = message.split("\n", -1);
//		if(s != null) {
//			for (int i = 0; i < s.length; i++) {
//				String data = s[i].trim();
//				if(data.startsWith("IF-MIB") || data.startsWith("SNMPv2-SMI")) {
//					sb.append(data).append(System.lineSeparator());
//				}
//			}
//		}
//		System.out.println(sb.toString());
//	}
	
	public static String replaceStatFilePattern(String statFilePattern,String ip){
		String result = "";
		if(statFilePattern == null || statFilePattern.isEmpty()){
			System.out.println("statFilePattern is not null or empty.");
			return result;
		}else if(ip == null || ip.isEmpty()){
			System.out.println("ip is not null or empty.");
			return result;
		}
		String dateFormat = "yyyyMMdd_HHmmss";
		String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern(dateFormat));
		result = statFilePattern.replaceAll("\\{IP\\}", ip);
		result = result.replaceAll("\\{YYYYMMDD_HH24MI\\}", dateTime);
		return result;
	}
	
	public static void sendSocket() {
		try {
			String message = "COMBINE|192.56.9.204|prawitaa|28/06/13 16:04:04|C417005558|Critical|specified username is invalid|Misc|PUBGW413_UBGWF_MAPDRIVE_11|CombindTT|FAULT|TM02A|bsc|TT20-0007024|bmcLogApplicationError|32";
			Socket socket = new Socket();
			socket.setSoTimeout(6000);
			socket.connect(new InetSocketAddress("10.138.32.103", Integer.parseInt("1504")),1000);
			OutputStream outstream = socket.getOutputStream();
			PrintWriter out = new PrintWriter(outstream);
			out.print(message);
			out.println("");
			out.close();
			socket.close();
			System.out.println(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
