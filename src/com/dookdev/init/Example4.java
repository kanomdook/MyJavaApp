package com.dookdev.init;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;

import com.dookdev.beans.VASTemplateGroupAlarm;
import com.dookdev.beans.VASTemplateGroupCommand;
import com.dookdev.beans.VASTemplateGroupDeclare;
import com.dookdev.beans.VASWITemplateInfo;

public class Example4 {

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
		groupAlarm.setJumpHost("PINSSMFRA202G");
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
		listCommand.add("CHECKTOCONTINUE ({Id} = \"toro\") \"Error : Cannot su toro\"");
		listCommand.add("SENDCMD \"cd /eqx/af/recovery/permanentError\" \"$\"");
		listCommand.add("SENDCMD \"pwd\" \"$\" \"{Path}\"");
		listCommand.add(
				"CHECKTOCONTINUE ({Path} = \"/eqx/af/recovery/permanentError\") \"Error : Cannot cd /eqx/af/recovery/permanentError\"");
		listCommand.add("SENDCMDTIMEOUT \"mv 1.txt 2.txt\" \"$\" \"{Path}\" \"30\"");
		listCommand.add("GETALARMINFO \"{Instance}\" \"DESCRIPTION\" \".*Oracle[WEBDB].*\"");
		listCommand.add("LOOKUPTABLE \"BMC_Agent_PORT_ORACLE\" \"{Instance}\" \"{Port}\"");
		listCommand.add("SENDCMD \"net ORACLE.name {Port}\" \"$\"");
		listCommand.add("WAIT \"5\"");
		listCommand.add(
				"RETURNRESULT ({Port} = \"8080\") ? \"Success\" : \"Error : Cannot start {Instance} PatrolAgent\"");
		groupCommand.setListCommand(listCommand);
		template.setGroupCommand(groupCommand);
		//
//		System.out.println("====================Template Data==================");
//		System.out.println(template);
		System.out.println("====================Check Node Keys=========");
		System.out.println(checkNodeKeys(template.getGroupAlarm().getCol1(), template.getGroupAlarm().getJumpHost(), template.getGroupAlarm().getNodeKey()));
	}
	
	public static boolean checkNodeKeys(String exCol1, String jumpHost, LinkedList<String> nodeKey) {
		boolean o = true;
		int index = nodeKey.indexOf(jumpHost);
		int _index = nodeKey.indexOf(exCol1);
		if (index < 0 && _index < 0) {
			o = false;
		}
		return o;
	}

}
