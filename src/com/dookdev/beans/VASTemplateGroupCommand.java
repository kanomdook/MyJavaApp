package com.dookdev.beans;

import java.util.ArrayList;

public class VASTemplateGroupCommand {
	
	private ArrayList<String> listCommand;

	public ArrayList<String> getListCommand() {
		return listCommand;
	}

	public void setListCommand(ArrayList<String> listCommand) {
		this.listCommand = listCommand;
	}

	@Override
	public String toString() {
		return "VASTemplateGroupCommand [listCommand=" + listCommand + "]";
	}

	

}
