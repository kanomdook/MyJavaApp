package com.dookdev.init;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex15 {

	public static void main(String[] args) {
		String CMDRes = "Port  Name                 Status      Vlan  Duplex  Speed    Type\r\n" + 
				"gi1   WIFI                 connected   204   a-full  a-1000M  Copper\r\n" + 
				"gi2   WIFI                 connected   204   a-full  a-100M   Copper\r\n" + 
				"gi3   WIFI                 notconnect  204   auto    auto     Copper\r\n" + 
				"gi4   WIFI                 notconnect  204   auto    auto     Copper\r\n" + 
				"gi5   WIFI                 notconnect  204   auto    auto     Copper\r\n" + 
				"gi6   WIFI                 notconnect  204   auto    auto     Copper\r\n" + 
				"gi7   BOH-Internal         connected   445   a-full  a-100M   Copper\r\n" + 
				"gi8   BOH-Internal         connected   445   a-full  a-100M   Copper\r\n" + 
				"gi9   BOH-Internal         notconnect  445   auto    auto     Copper\r\n" + 
				"gi10  BOH-Internal         connected   445   a-full  a-100M   Copper\r\n" + 
				"gi11  BOH-Internal         connected   445   a-full  a-1000M  Copper\r\n" + 
				"gi12  BOH-Internal         connected   445   a-full  a-1000M  Copper\r\n" + 
				"gi13  BOH-Internal         notconnect  445   auto    auto     Copper\r\n" + 
				"gi14  BOH-Internal         notconnect  445   auto    auto     Copper\r\n" + 
				"gi15  BOH-Internal         notconnect  445   auto    auto     Copper\r\n" + 
				"gi16  BOH-External         notconnect  200   auto    auto     Copper\r\n" + 
				"gi17  BOH-External         notconnect  200   auto    auto     Copper\r\n" + 
				"gi18  BOH-External         connected   200   a-half  a-100M   Copper\r\n" + 
				"gi19  BOH-External         connected   200   full    100M     Copper\r\n" + 
				"gi20  BOH-External         notconnect  200   full    100M     Copper\r\n" + 
				"gi21  BOH-External         connected   200   full    100M     Copper\r\n" + 
				"gi22  BOH-External         connected   200   a-full  a-1000M  Copper\r\n" + 
				"gi23  BOH-External         connected   200   a-full  a-100M   Copper\r\n" + 
				"gi24  BOH-External         connected   200   a-full  a-1000M  Copper\r\n" + 
				"gi25  CONNECT-TO-ROUTER-CISCO819 connected   445   a-full  a-100M   Copper\r\n" + 
				"gi26  upkink-to-SWC300     connected   1     a-full  a-1000M  Copper\r\n" + 
				"\r\n" + 
				"Port Time Range                       Status\r\n" + 
				"---- -------------------------------- --------\r\n" + 
				"gi1\r\n" + 
				"gi2\r\n" + 
				"gi3\r\n" + 
				"gi4\r\n" + 
				"gi5\r\n" + 
				"gi6\r\n" + 
				"gi7\r\n" + 
				"gi8\r\n" + 
				"gi9\r\n" + 
				"gi10\r\n" + 
				"gi11\r\n" + 
				"gi12\r\n" + 
				"gi13\r\n" + 
				"gi14\r\n" + 
				"gi15\r\n" + 
				"gi16\r\n" + 
				"gi17\r\n" + 
				"gi18\r\n" + 
				"gi19\r\n" + 
				"gi20\r\n" + 
				"gi21\r\n" + 
				"gi22\r\n" + 
				"gi23\r\n" + 
				"gi24\r\n" + 
				"gi25\r\n" + 
				"gi26\r\n" + 
				"";
		
//		System.out.println(CMDRes);
		String port = "1";
		String regex="gi"+port+"\\s.*connected.*a-full\\s+a-1000M.*";
		Matcher match;
     	Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
     	CMDRes =  CMDRes.replaceAll("\r\n", "\n");
	    
		String data[] =  CMDRes.split("\n");
		for(int i = 1; i < data.length; i++) {
			match = pattern.matcher(data[i].trim());
			if(match.matches()) {
				System.out.println(data[i]);
				System.out.println("match");
				break;
			}
		}

	}

}
