package com.dookdev.init;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex13 {

	public static void main(String[] args) {
		String res = "display mac-address dynamic GigabitEthernet 0/0/1\r\n" + 
				"-------------------------------------------------------------------------------\r\n" + 
				"MAC Address    VLAN/VSI                          Learned-From        Type\r\n" + 
				"-------------------------------------------------------------------------------\r\n" + 
				"f80f-6f8a-26d0 611/-                             GE0/0/1             dynamic\r\n" + 
				"\r\n" + 
				"-------------------------------------------------------------------------------\r\n" + 
				"Total items displayed = 1";

		
		ArrayList<String> result = getMACAddressHuawei5720(res);
		
		System.out.println(">>> result size: " + result.size());
		
		System.out.println(result.toString());
	}
	
	public static ArrayList<String> getMACAddressHuawei5720(String response){
		String regex = "(.*)\\s+.*GE0/0/1.*dynamic.*";
//		String regex = ".*#.*|.*More.*|.*>.*|.*\\(more\\).*";
		ArrayList<String> macList= new ArrayList<String>();
		Pattern pattern;
		Matcher match;
		pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
		response =  response.replaceAll("\r\n", "\n");
		String data[] =  response.split("\n",-1);
		for(int i = 1; i < data.length; i++) {
			if(data[i].trim().isEmpty())
				continue;
			match = pattern.matcher(data[i].trim());
			if(match.find()) {
				String a = match.group(1).trim();
				 String[] b = a.split(" ");
				 if(b.length > 0) {
					 macList.add(b[0]);
				 }
			}
		}
		return macList;
	}

}
