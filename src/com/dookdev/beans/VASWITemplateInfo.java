package com.dookdev.beans;

public class VASWITemplateInfo {

	private VASTemplateGroupAlarm groupAlarm;
	private VASTemplateGroupDeclare groupDeclare;
	private VASTemplateGroupCommand groupCommand;

	public VASTemplateGroupAlarm getGroupAlarm() {
		return groupAlarm;
	}

	public void setGroupAlarm(VASTemplateGroupAlarm groupAlarm) {
		this.groupAlarm = groupAlarm;
	}

	public VASTemplateGroupDeclare getGroupDeclare() {
		return groupDeclare;
	}

	public void setGroupDeclare(VASTemplateGroupDeclare groupDeclare) {
		this.groupDeclare = groupDeclare;
	}

	public VASTemplateGroupCommand getGroupCommand() {
		return groupCommand;
	}

	public void setGroupCommand(VASTemplateGroupCommand groupCommand) {
		this.groupCommand = groupCommand;
	}

	@Override
	public String toString() {
		return "VASWITemplateInfo [groupAlarm=" + groupAlarm + ", groupDeclare=" + groupDeclare + ", groupCommand="
				+ groupCommand + "]";
	}

}
