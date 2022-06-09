package com.dookdev.init;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import com.dookdev.beans.VASWITemplateInfo;
import com.dookdev.beans.VASTemplateGroupAlarm;
import com.dookdev.beans.VASTemplateGroupCommand;
import com.dookdev.beans.VASTemplateGroupDeclare;

public class Example3 {

	public static void main(String[] args) {
		VASWITemplateInfo template = new VASWITemplateInfo();
		VASTemplateGroupAlarm groupAlarm = new VASTemplateGroupAlarm();
		VASTemplateGroupDeclare groupDeclare = new VASTemplateGroupDeclare();
		VASTemplateGroupCommand groupCommand = new VASTemplateGroupCommand();
		// Mockup Data groupAlarm For Test //
		groupAlarm.setCol1("");
		groupAlarm.setCol2("VASDB_AIS_VAS");
		groupAlarm.setAlertName("");
		groupAlarm.setAmoName("");
		groupAlarm.setDescription("*permanentError*");
		groupAlarm.setJumpHost("");
		LinkedList<String> nodeKey = new LinkedList<String>();
		nodeKey.add("PINSSMFRA201G");
		nodeKey.add("PINSSMFRA202G");
		nodeKey.add("PINSSMFRA801G");
		nodeKey.add("PINSSMFRA802G");
		groupAlarm.setNodeKey(nodeKey);
		template.setGroupAlarm(groupAlarm);
		// Mockup Data groupDeclare For Test //
		groupDeclare.setAutoJob("N");
		groupDeclare.setWorkHourStartTime("00:59:39");
		groupDeclare.setWorkHourEndTime("05:59:59");
		groupDeclare.setWorkHourResponseError("Out of work hour (00:00:00 - 05:59:59)");
		groupDeclare.setMaxInTimeHr("2");
		groupDeclare.setMaxInTimeHrResponseError("Max in time HR (2)");
		groupDeclare.setMaxInTime24Hr("5");
		groupDeclare.setMaxInTime24HrResponseError("Max in time 24 HR (5)");
		groupDeclare.setExpectTime("10");
		Hashtable<String, String> varString = new Hashtable<String, String>();
		varString.put("Id", "1234");
		varString.put("Path", "/www/app/");
		varString.put("Instance", "xxxxx");
		varString.put("Port", "22");
		Hashtable<String, Integer> varInt = new Hashtable<String, Integer>();
		varInt.put("Count", 0);
		groupDeclare.setVarString(varString);
		groupDeclare.setVarInt(varInt);
		template.setGroupDeclare(groupDeclare);
		// Mockup Data groupCommand For Test //
		ArrayList<String> listCommand = new ArrayList<String>();
		listCommand.add("SENDCMD \"su-toro\" \"Password:\"");
		listCommand.add("SENDCMD \"abcd\" \"$\"");
		listCommand.add("SENDCMD \"id -un\" \"$\" \"{Id}\"");
		listCommand.add("CHECKTOCONTINUE ({Id} = \"toro\") ? \"\" : \"Error : Cannot su toro\"");
		listCommand.add("SENDCMD \"cd /eqx/af/recovery/permanentError\" \"$\"");
		listCommand.add("SENDCMD \"pwd\" \"$\" \"{Path}\"");
		listCommand.add(
				"CHECKTOCONTINUE ({Path} = \"/eqx/af/recovery/permanentError\") ? \"\" : \"Error : Cannot cd /eqx/af/recovery/permanentError\"");
		listCommand.add("SENDCMDTIMEOUT \"mv 1.txt 2.txt\" \"$\" \"{Path}\" \"30\"");
		listCommand.add("GETALARMINFO \"{Instance}\" \"DESCRIPTION\" \".*Oracle[WEBDB].*\"");
		listCommand.add("LOOKUPTABLE \"BMC_Agent_PORT_ORACLE\" \"{Instance}\" \"{Port}\"");
		listCommand.add("SENDCMD \"net ORACLE.name {Port}\" \"$\"");
		listCommand.add("WAIT \"5\"");
		listCommand.add(
				"RETURNRESULT ({Port} regx \"8080\") ? \"Success\" : \"Error : Cannot start {Instance} PatrolAgent\"");
		groupCommand.setListCommand(listCommand);
		template.setGroupCommand(groupCommand);
		//
//		System.out.println("====================Template Data==================");
//		System.out.println(template);
		System.out.println("====================Check Syntax WI Result=========");
		System.out.println(checkSyntaxWI(template));
	}

	public static Hashtable<String, String> checkSyntaxWI(VASWITemplateInfo template) {
		Hashtable<String, String> result = new Hashtable<String, String>();
		result = handleMessage("true", "");
		try {
			if (template != null && template.getGroupDeclare() != null
					&& template.getGroupDeclare().getWorkHourStartTime() != null
					&& template.getGroupDeclare().getWorkHourStartTime() != "") {
				String workHourStartTime = template.getGroupDeclare().getWorkHourStartTime();
				if (!validateTimeFormat(workHourStartTime)) {
					result = handleMessage("false", "workHourStartTime is " + workHourStartTime
							+ " invalid time format, please fill in format 00:00:00");
				}
			}
			if (template != null && template.getGroupDeclare() != null
					&& template.getGroupDeclare().getWorkHourEndTime() != null
					&& template.getGroupDeclare().getWorkHourEndTime() != "") {
				String workHourEndTime = template.getGroupDeclare().getWorkHourEndTime();
				if (!validateTimeFormat(workHourEndTime)) {
					result = handleMessage("false", "workHourEndTime is " + workHourEndTime
							+ " invalid time format, please fill in format 00:00:00");
				}
			}

			ArrayList<String> groupCommandList = template.getGroupCommand().getListCommand();
			String[] cmdList = { "SENDCMD", "CHECKTOCONTINUE", "SENDCMDTIMEOUT", "GETALARMINFO", "LOOKUPTABLE", "WAIT",
					"RETURNRESULT" };

			for (String cmd : groupCommandList) {
				String[] spltTxt = cmd.split(" ");
				String _cmd = spltTxt[0];
				if (spltTxt.length > 2 || _cmd.equals("WAIT")) {
					int index = ArrayUtils.indexOf(cmdList, _cmd);
					if (index >= 0) {
						if (_cmd.equals("SENDCMD")) {
							if (validateSENDCMDFormat(cmd)) {

							} else if (validateSENDCMDWithParameterFormat(cmd)) {

							} else {
								result = handleMessage("false", cmd + " invalid format");
								break;
							}
						} else if (_cmd.equals("CHECKTOCONTINUE")) {
							if (!validateCHECKTOCONTINUEFormat(cmd)) {
								result = handleMessage("false", cmd + " invalid format");
								break;
							}
						} else if (_cmd.equals("SENDCMDTIMEOUT")) {
							if (!validateSENDCMDTIMEOUTFormat(cmd)) {
								result = handleMessage("false", cmd + " invalid format");
								break;
							}
						} else if (_cmd.equals("GETALARMINFO")) {
							if (!validateGETALARMINFOFormat(cmd)) {
								result = handleMessage("false", cmd + " invalid format");
								break;
							}
						} else if (_cmd.equals("LOOKUPTABLE")) {
							if (!validateLOOKUPTABLEFormat(cmd)) {
								result = handleMessage("false", cmd + " invalid format");
								break;
							}
						} else if (_cmd.equals("WAIT")) {
							if (!validateWAITFormat(cmd)) {
								result = handleMessage("false", cmd + " invalid format");
								break;
							}
						} else if (_cmd.equals("RETURNRESULT")) {
							if (!validateRETURNRESULTFormat(cmd)) {
								result = handleMessage("false", cmd + " invalid format");
								break;
							}
						}
					} else {
						result = handleMessage("false", _cmd + " is invalid command");
						break;
					}
				} else {
					result = handleMessage("false", cmd + " invalid format");
					break;
				}
				Hashtable<String, String> checkValiableResult = checkValiable(template.getGroupDeclare().getVarString(),
						template.getGroupDeclare().getVarInt(), cmd);
				if (checkValiableResult.get("result").equals("false")) {
					result = checkValiableResult;
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static boolean validateTimeFormat(String time) {
		boolean o = true;
		// original "^(\d\d:\d\d:\d\d)$"
		final Pattern pattern = Pattern.compile("^(\\d\\d:\\d\\d:\\d\\d)$");
		Matcher matcher = pattern.matcher(time);
		if (matcher.matches()) {
			String[] splTime = time.split(":");
			int h = Integer.parseInt(splTime[0]);
			int m = Integer.parseInt(splTime[1]);
			int s = Integer.parseInt(splTime[2]);
			if (h < 0 || h > 23) {
				o = false;
			} else if (m < 0 || m > 59) {
				o = false;
			} else if (s < 0 || s > 59) {
				o = false;
			}
		} else {
			o = false;
		}
		return o;
	}

	public static boolean validateSENDCMDFormat(String cmd) {
		// original
		// "^([A-Z]+\s\"[\sa-zA-Z\/0-9{}_$&+,:;=?@\[\]#|'<>.^*()%!-]*\"\s\"[\sa-zA-Z\/0-9{}_$&+,:;=?@\[\]#|'<>.^*()%!-]*\")$"
		final Pattern pattern = Pattern.compile(
				"^([A-Z]+\\s\\\"[\\sa-zA-Z\\/0-9{}_$&+,:;=?@\\[\\]#|'<>.^*()%!-]*\\\"\\s\\\"[\\sa-zA-Z\\/0-9{}_$&+,:;=?@\\[\\]#|'<>.^*()%!-]*\\\")$");
		Matcher matcher = pattern.matcher(cmd);
		return matcher.matches();
	}

	public static boolean validateSENDCMDWithParameterFormat(String cmd) {
		// original
		// "^([A-Z]+\s\"[\sa-zA-Z\/0-9{}_$&+,:;=?@\[\]#|'<>.^*()%!-]*\"\s\"[\sa-zA-Z\/0-9{}_$&+,:;=?@\[\]#|'<>.^*()%!-]*\"\s\"(\{{1}([a-zA-Z0-9]){1,}\}{1}){0,1}\")$"
		final Pattern pattern = Pattern.compile(
				"^([A-Z]+\\s\\\"[\\sa-zA-Z\\/0-9{}_$&+,:;=?@\\[\\]#|'<>.^*()%!-]*\\\"\\s\\\"[\\sa-zA-Z\\/0-9{}_$&+,:;=?@\\[\\]#|'<>.^*()%!-]*\\\"\\s\\\"(\\{{1}([a-zA-Z0-9]){1,}\\}{1}){0,1}\\\")$");
		Matcher matcher = pattern.matcher(cmd);
		return matcher.matches();
	}

	public static boolean validateCHECKTOCONTINUEFormat(String cmd) {
		// original
		// "^([A-Z]*\s\(((\"[\sa-zA-Z\/0-9{}_$&+,:;=?@\[\]#|'<>.^*()%!-]*\")|([0-9]{1,})|(\{{1}([a-zA-Z0-9]){1,}\}{1}))\s{0,}([=><!]{1,2}|regx{1,1}|contains{1,1})\s{0,}((\"[\sa-zA-Z\/0-9{}_$&+,:;=?@\[\]#|'<>.^*()%!-]*\")|([0-9]{1,})|(\{{1}([a-zA-Z0-9]){1,}\}{1}))\)\s{0,}\?\s{0,}\"[\sa-zA-Z\/0-9{}_$&+,:;=?@\[\]#|'<>.^*()%!-]*\"\s{0,}\:\s{0,}\"[\sa-zA-Z\/0-9{}_$&+,:;=?@\[\]#|'<>.^*()%!-]*\")$"
		final Pattern pattern = Pattern.compile(
				"^([A-Z]*\\s\\(((\\\"[\\sa-zA-Z\\/0-9{}_$&+,:;=?@\\[\\]#|'<>.^*()%!-]*\\\")|([0-9]{1,})|(\\{{1}([a-zA-Z0-9]){1,}\\}{1}))\\s{0,}([=><!]{1,2}|regx{1,1}|contains{1,1})\\s{0,}((\\\"[\\sa-zA-Z\\/0-9{}_$&+,:;=?@\\[\\]#|'<>.^*()%!-]*\\\")|([0-9]{1,})|(\\{{1}([a-zA-Z0-9]){1,}\\}{1}))\\)\\s{0,}\\?\\s{0,}\\\"[\\sa-zA-Z\\/0-9{}_$&+,:;=?@\\[\\]#|'<>.^*()%!-]*\\\"\\s{0,}\\:\\s{0,}\\\"[\\sa-zA-Z\\/0-9{}_$&+,:;=?@\\[\\]#|'<>.^*()%!-]*\\\")$");
		Matcher matcher = pattern.matcher(cmd);
		return matcher.matches();
	}

	public static boolean validateSENDCMDTIMEOUTFormat(String cmd) {
		// original
		// "^([A-Z]*\s\"[\sa-zA-Z\/0-9{}_$&+,:;=?@\[\]#|'<>.^*()%!-]*\"\s\"[\sa-zA-Z\/0-9{}_$&+,:;=?@\[\]#|'<>.^*()%!-]*\"\s\"(\{{1}([a-zA-Z0-9]){1,}\}{1}){0,1}\"\s\"[0-9]*\")$"
		final Pattern pattern = Pattern.compile(
				"^([A-Z]*\\s\\\"[\\sa-zA-Z\\/0-9{}_$&+,:;=?@\\[\\]#|'<>.^*()%!-]*\\\"\\s\\\"[\\sa-zA-Z\\/0-9{}_$&+,:;=?@\\[\\]#|'<>.^*()%!-]*\\\"\\s\\\"(\\{{1}([a-zA-Z0-9]){1,}\\}{1}){0,1}\\\"\\s\\\"[0-9]*\\\")$");
		Matcher matcher = pattern.matcher(cmd);
		return matcher.matches();
	}

	public static boolean validateGETALARMINFOFormat(String cmd) {
		// original
		// "^([A-Z]*\s\"(\{{1}([a-zA-Z0-9]){1,}\}{1}){0,1}\"\s\"[A-Z]*\"\s\"[\sa-zA-Z\/0-9{}_$&+,:;=?@\[\]#|'<>.^*()%!-]*\")$"
		final Pattern pattern = Pattern.compile(
				"^([A-Z]*\\s\\\"(\\{{1}([a-zA-Z0-9]){1,}\\}{1}){0,1}\\\"\\s\\\"[A-Z]*\\\"\\s\\\"[\\sa-zA-Z\\/0-9{}_$&+,:;=?@\\[\\]#|'<>.^*()%!-]*\\\")$");
		Matcher matcher = pattern.matcher(cmd);
		return matcher.matches();
	}

	public static boolean validateLOOKUPTABLEFormat(String cmd) {
		// original
		// "^([A-Z]*\s\"[a-zA-Z0-9_]*\"\s\"(\{{1}([a-zA-Z0-9]){1,}\}{1}){0,1}\"\s\"(\{{1}([a-zA-Z0-9]){1,}\}{1}){0,1}\")$"
		final Pattern pattern = Pattern.compile(
				"^([A-Z]*\\s\\\"[a-zA-Z0-9_]*\\\"\\s\\\"(\\{{1}([a-zA-Z0-9]){1,}\\}{1}){0,1}\\\"\\s\\\"(\\{{1}([a-zA-Z0-9]){1,}\\}{1}){0,1}\\\")$");
		Matcher matcher = pattern.matcher(cmd);
		return matcher.matches();
	}

	public static boolean validateWAITFormat(String cmd) {
		// original "^([A-Z]*\s\"[0-9]*\")$"
		final Pattern pattern = Pattern.compile("^([A-Z]*\\s\\\"[0-9]*\\\")$");
		Matcher matcher = pattern.matcher(cmd);
		return matcher.matches();
	}

	public static boolean validateRETURNRESULTFormat(String cmd) {
		// original
		// "^([A-Z]*\s\(((\"[\sa-zA-Z\/0-9{}_$&+,:;=?@\[\]#|'<>.^*()%!-]*\")|([0-9]{1,})|(\{{1}([a-zA-Z0-9]){1,}\}{1}))\s{0,}([=><!]{1,2}|regx{1,1}|contains{1,1})\s{0,}((\"[\sa-zA-Z\/0-9{}_$&+,:;=?@\[\]#|'<>.^*()%!-]*\")|([0-9]{1,})|(\{{1}([a-zA-Z0-9]){1,}\}{1}))\)\s{0,}\?\s{0,}\"[\sa-zA-Z\/0-9{}_$&+,:;=?@\[\]#|'<>.^*()%!-]*\"\s{0,}\:\s{0,}\"[\sa-zA-Z\/0-9{}_$&+,:;=?@\[\]#|'<>.^*()%!-]*\")$"
		final Pattern pattern = Pattern.compile(
				"^([A-Z]*\\s\\(((\\\"[\\sa-zA-Z\\/0-9{}_$&+,:;=?@\\[\\]#|'<>.^*()%!-]*\\\")|([0-9]{1,})|(\\{{1}([a-zA-Z0-9]){1,}\\}{1}))\\s{0,}([=><!]{1,2}|regx{1,1}|contains{1,1})\\s{0,}((\\\"[\\sa-zA-Z\\/0-9{}_$&+,:;=?@\\[\\]#|'<>.^*()%!-]*\\\")|([0-9]{1,})|(\\{{1}([a-zA-Z0-9]){1,}\\}{1}))\\)\\s{0,}\\?\\s{0,}\\\"[\\sa-zA-Z\\/0-9{}_$&+,:;=?@\\[\\]#|'<>.^*()%!-]*\\\"\\s{0,}\\:\\s{0,}\\\"[\\sa-zA-Z\\/0-9{}_$&+,:;=?@\\[\\]#|'<>.^*()%!-]*\\\")$");
		Matcher matcher = pattern.matcher(cmd);
		return matcher.matches();
	}

	public static Hashtable<String, String> checkValiable(Hashtable<String, String> varString,
			Hashtable<String, Integer> varInt, String cmd) {
		Hashtable<String, String> o = new Hashtable<String, String>();
		o = handleMessage("true", "");
		// original "\{[a-zA-Z0-9]*\}"
		final Pattern pattern = Pattern.compile("\\{[a-zA-Z0-9]*\\}");
		Matcher matcher = pattern.matcher(cmd);
		while (matcher.find()) {
			String _valiable = StringUtils.substringBetween(matcher.group(), "{", "}");
			if (!varString.containsKey(_valiable) && !varInt.containsKey(_valiable)) {
				o = handleMessage("false", "parameter " + _valiable + " is undefined");
				break;
			}
		}
		return o;
	}

	public static Hashtable<String, String> handleMessage(String result, String message) {
		Hashtable<String, String> o = new Hashtable<String, String>();
		o.put("result", result);
		o.put("message", message);
		return o;
	}

}
