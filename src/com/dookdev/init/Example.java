package com.dookdev.init;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.commons.lang3.StringUtils;

import com.dookdev.beans.RequestAlarm;
import com.dookdev.beans.VASAlarmHistory;
import com.dookdev.beans.VASNodeInfo;

public class Example {
	public static VASAlarmHistory history = new VASAlarmHistory();
	private static int count;
	private static int maxIn24HrCount = 0;

	public static void main(String[] args) {
		// Mock up data //
				history.setFirstAlarmTime("1596085929251");
				history.setMaxInHr(2);
				history.setMaxIn24Hr(5);
		//
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				String[] alarmHistoryTestList = {
						"30/07/2020 10:00:01",
						"30/07/2020 10:10:00",
						"30/07/2020 10:20:00",
						"30/07/2020 10:30:00",
						"30/07/2020 11:30:00",
						"30/07/2020 11:40:00",
						"30/07/2020 11:50:00",
						"30/07/2020 14:10:00",
						"30/07/2020 14:20:00",
						"30/07/2020 14:30:00",
						"30/07/2020 17:30:00",
						"30/07/2020 18:30:00"
				};
				System.out.println("================[data:"+count+"]=================");
				System.out.println("******Output*********************");
				System.out.println(validateMaxInTime("Node001", alarmHistoryTestList[count]));
				System.out.println("******RoundHour(HH=count)********");
				System.out.println(history.getRoundHour());
				System.out.println("******AlarmHistory Data**********");
				System.out.println(alarmHistoryTestList[count]);
				System.out.println("==========================================");
				count++;
			}
		}, 1000, 2000);
	}

	public static Hashtable<String, String> validateMaxInTime(String nodeName, String alarmTime) {
		Hashtable<String, String> o = new Hashtable<String, String>();
		try {
			Hashtable<String, Integer> roundHour = new Hashtable<String, Integer>();
			String[] dateTimeArr = alarmTime.split(" ");
			String[] timeArr = dateTimeArr[1].split(":");
			Hashtable<String, Integer> roundHourList = history.getRoundHour();	
			
			if(roundHourList == null || roundHourList.isEmpty()) {
				o.put("valid","true");
				o.put("message","true");
				roundHour.put(timeArr[0], 1);
				maxIn24HrCount++;
			}else {
				boolean isKey = roundHourList.containsKey(timeArr[0]);
				if(isKey) {
					Integer countRoundHour = roundHourList.get(timeArr[0]);
					if(countRoundHour < history.getMaxInHr()) {
						o.put("valid","true");
						o.put("message","true");
						maxIn24HrCount++;
					}else {
						o.put("valid","false");
						o.put("message","Max in HR");
					}
					countRoundHour++;
					roundHour.put(timeArr[0], countRoundHour);
				}else {
					roundHour.put(timeArr[0], 1);
					o.put("valid","true");
					o.put("message","true");
					maxIn24HrCount++;
				}
			}
			history.setRoundHour(roundHour);
			if(maxIn24HrCount > history.getMaxIn24Hr()) {
				o.put("valid","false");
				o.put("message","Max in 24HR");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return o;
	}
	
	public static Boolean isValidWorkHour(String startTime, String endTime, String alarmTime) {
		boolean isValidWorkHour = false;
		try {
			long millis = Long.parseLong(alarmTime);
			Calendar calendar = Calendar.getInstance();
			calendar.setTimeInMillis(millis);
			String hour = Integer.toString(calendar.get(Calendar.HOUR_OF_DAY));
			String minute = Integer.toString(calendar.get(Calendar.MINUTE));
			String second = Integer.toString(calendar.get(Calendar.SECOND));
			String time = hour + ":" + minute + ":" + second;
			System.out.println("Start time is: " + startTime);
			System.out.println("End time is: " + endTime);
			System.out.println("Alarm time millisecond is: " + alarmTime + " convert to time is: " + time);
			SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
			Date date1 = format.parse(startTime);
			Date date2 = format.parse(endTime);
			Date alarmDate = format.parse(time);
			long _startTime = date1.getTime();
			long _endTime = date2.getTime();
			long _alarmTime = alarmDate.getTime();
			if ((_alarmTime >= _startTime) && (_alarmTime <= _endTime)) {
				isValidWorkHour = true;
			} else {
				isValidWorkHour = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Valid work hour is: " + isValidWorkHour);
		return isValidWorkHour;
	}
	
	public static void callFM(RequestAlarm request,String data){
		try{
//			String code="E000";
//			String message="E000:Success";
//			
//			ResponseAlarm respAlarm = new ResponseAlarm();
//			respAlarm.setRetureCode(code);
//			respAlarm.setReturnMessage(message);
//			respAlarm.setReturnData(data);
//			respAlarm.setServerserial(request.getServerserial());
//			
//			String response = SendAlarmUtil.callService(respAlarm);
//			LOGGER.info("Call FM response:" + response);
		}catch(Exception ex){
			throw ex;
		}
	}

	public static Hashtable<String, VASNodeInfo> getAllVASNodeInfo() {
		Hashtable<String, VASNodeInfo> nodeList = new Hashtable<String, VASNodeInfo>();
		try {
			File file = new File("./vas/Node2.txt");
			Scanner scanner = new Scanner(file);
			String content = "";
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				content += line.trim() + "\n";
			}
			String[] nodeContents = content.split("\\n\\n");
			for (int i = 0; i < nodeContents.length; i++) {
				String node = StringUtils.substringBetween(nodeContents[i].toString(), "NODE", "END NODE");
				String[] splNode = node.split("\n");
				VASNodeInfo nodeInfo = new VASNodeInfo();
				String nodeName = "";
				for (int j = 0; j < splNode.length; j++) {
					if (splNode[j].split(" ").length > 1) {
						String[] nodeArr = splNode[j].split(" ");
						String val = nodeArr[1].replaceAll("\"", "");
						if (nodeArr[0].equals("NAME")) {
							nodeName = val;
							nodeInfo.setName(nodeName);
						} else if (nodeArr[0].equals("IP")) {
							nodeInfo.setIp(val);
						} else if (nodeArr[0].equals("PORT")) {
							nodeInfo.setPort(val);
						} else if (nodeArr[0].equals("USER")) {
							nodeInfo.setUser(val);
						} else if (nodeArr[0].equals("PASSWORD")) {
							nodeInfo.setPassword(val);
						}
					}
				}
				nodeList.put(nodeName, nodeInfo);
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

	public static void readFile() {
		try {
			File file = new File("./vas/VAS_WI_11111.wi");
			Scanner scanner = new Scanner(file);
			String content = "";
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				if (!line.startsWith("//") && !line.equalsIgnoreCase("")) {
					content += line.trim() + "\n";
				}
			}
			String replaceContent = content.replaceAll("(?s)/\\*.*?\\*/", "");
			spliteTemplate(replaceContent);
			scanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void spliteTemplate(String content) {
		String[] templates = content.split("END TEMPLATE");
		for (int i = 0; i < templates.length; i++) {
			String template = templates[i].toString();
			if (isNotEmptyData(template)) {
				System.out.println("=====================Result " + i + " =================");
				String var = StringUtils.substringBetween(template, "TEMPLATE", "DECARE");
				String decare = StringUtils.substringBetween(template, "DECARE", "END DECARE");
				String begin = StringUtils.substringBetween(template, "BEGIN", "END BEGIN");
				System.out.println(var);
				System.out.println(decare);
				System.out.println(begin);
			}
		}
	}

	public static Boolean isNotEmptyData(String template) {
		if ((template.toString() != null) && (template.toString().length() != 0)
				&& (template.toString().length() != 1)) {
			return true;
		} else {
			return false;
		}
	}

}
