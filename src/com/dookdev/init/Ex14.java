package com.dookdev.init;

public class Ex14 {
	public  static final String MSG_CANNOT_ACCESS_SWITCH_L2="Cannot Access Switch L2";
	public  static final String MSG_CANNOT_ACCESS_SWITCH_L2_WITH_NONMOBILE="Cannot Access Switch L2; nonMobile: %s";
	public static void main(String[] args) {
		String nonMobile = "9000001234";
		String msgCannotAccessSwitchL2 = String.format(MSG_CANNOT_ACCESS_SWITCH_L2_WITH_NONMOBILE, nonMobile);
		System.out.println(msgCannotAccessSwitchL2);
		
	    System.out.println(msgCannotAccessSwitchL2.contains(MSG_CANNOT_ACCESS_SWITCH_L2));
	}

}
