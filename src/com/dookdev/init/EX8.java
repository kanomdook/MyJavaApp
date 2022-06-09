package com.dookdev.init;

public class EX8 {

	public static void main(String[] args) {
		String message = "Summary \r\n" + 
				"Need Onsite : Y \r\n" + 
				"Port detect 1000 Full : Y \r\n" + 
				"Ping AP WiFi :\r\n" + 
				"Telnet AP WiFi : Y \r\n" + 
				"Information \r\n" + 
				"Switch Name : R891.6SP69-POE \r\n" + 
				"IP Switch : 10.108.115.183 \r\n" + 
				"Switch Type: Router (CISCO C891F-K9-POE) \r\n" + 
				"AP Name : IMAX_MAJOR_FA0MB \r\n" + 
				"IP AP : 10.207.72.176 \r\n" + 
				"Mac Address AP : 28:94:0f:63:d8:4d \r\n" + 
				"Port AP Connect : 1 \r\n" + 
				"Model AP : AIR-LAP1142N-E-K9 \r\n" + 
				"AP Type : 4 \r\n" + 
				"ชื่อร้าน :   600299 (1064) - POS Amazon -TESCO LOTUS Rajapruk 1st Floor \r\n" + 
				"Site code : PAPR_LF \r\n" + 
				"AP Name : IMAX_MAJOR_FA0MBX \r\n" + 
				"IP AP : 10.207.72.177 \r\n" + 
				"Mac Address AP : 28:94:0f:63:d8:4e \r\n" + 
				"Port AP Connect : 2 \r\n" + 
				"Model AP : AIR-LAP1142N-E-K9X \r\n" + 
				"AP Type : 3 \r\n" + 
				"ชื่อร้าน :   600299 (1064) - POS Amazon -TESCO LOTUS Rajapruk 1st FloorX \r\n" + 
				"Site code : PAPR_LFX \r\n";
		
		String xx = "Summary\r\n" + 
				"Need Onsite : Y\r\n" + 
				"Port detect 1000 Full : Y\r\n" + 
				"Ping AP WiFi : Y\r\n" + 
				"Telnet AP WiFi : Y\r\n" + 
				"Information\r\n" + 
				"Switch Name : R891.6SP69-POE\r\n" + 
				"IP Switch : 10.108.115.183\r\n" + 
				"Switch Type: Router (CISCO C891F-K9-POE)\r\n" + 
				"AP Name : IMAX_MAJOR_FA0MB\r\n" + 
				"IP AP : 10.207.72.176\r\n" + 
				"Mac Address AP : 28:94:0f:63:d8:4d\r\n" + 
				"Port AP Connect : 1\r\n" + 
				"Model AP : AIR-LAP1142N-E-K9\r\n" + 
				"AP Type : 4\r\n" + 
				"ชื่อร้าน :   600299 (1064) - POS Amazon -TESCO LOTUS Rajapruk 1st Floor\r\n" + 
				"Site code : PAPR_LF\r\n" + 
				"AP Name : IMAX_MAJOR_FA0MBX\r\n" + 
				"IP AP : 10.207.72.177\r\n" + 
				"Mac Address AP : 28:94:0f:63:d8:4e\r\n" + 
				"Port AP Connect : 2\r\n" + 
				"Model AP : AIR-LAP1142N-E-K9X\r\n" + 
				"AP Type : 3\r\n" + 
				"ชื่อร้าน :   600299 (1064) - POS Amazon -TESCO LOTUS Rajapruk 1st FloorX\r\n" + 
				"Site code : PAPR_LFX";
		
		message = message.trim();
		message = message.replaceAll("\r", "");
		String[] s = message.split("\n", -1);
		if (s != null) {
			for (int i = 0; i < s.length; i++) {
				String data = s[i].trim();
				 String[] splitData = data.split(":", 2);
				 if(splitData.length >= 2) {
					 System.out.println(splitData[0].trim());
					 System.out.println(splitData[1].trim());
				 }
			}
		}
		
//		if(!xx.isEmpty()) {
//			return;
//		}
//		
//		System.out.println("=======Final=======");
		
		String aa = "%Site_Code% XXX";
		System.out.println(aa.replaceAll("%Site_Code%", "AAAA"));

	}

}
