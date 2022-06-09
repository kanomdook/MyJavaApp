package com.dookdev.init;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex7 {

	public static void main(String[] args) {
		try {
			SimpleDateFormat sdfx = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateString = "2020-06-03 18:14:43.0";
			Date date = sdfx.parse(dateString);
			System.out.println(dateString.substring(0,19));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
