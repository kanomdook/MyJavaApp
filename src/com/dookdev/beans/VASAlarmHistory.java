package com.dookdev.beans;

import java.util.ArrayList;
import java.util.Hashtable;

public class VASAlarmHistory {
    private String firstAlarmTime;
    private Hashtable<String,Integer> roundHour;
    private int maxInHr;
    private int maxIn24Hr;
    private ArrayList<String> alarmHistory;
    
    public String getFirstAlarmTime() {
        return firstAlarmTime;
    }
    public void setFirstAlarmTime(String firstAlarmTime) {
        this.firstAlarmTime = firstAlarmTime;
    }
    public Hashtable<String, Integer> getRoundHour() {
        return roundHour;
    }
    public void setRoundHour(Hashtable<String, Integer> roundHour) {
        this.roundHour = roundHour;
    }
    public int getMaxInHr() {
        return maxInHr;
    }
    public void setMaxInHr(int maxInHr) {
        this.maxInHr = maxInHr;
    }
    public int getMaxIn24Hr() {
        return maxIn24Hr;
    }
    public void setMaxIn24Hr(int maxIn24Hr) {
        this.maxIn24Hr = maxIn24Hr;
    }
    public ArrayList<String> getAlarmHistory() {
        return alarmHistory;
    }
    public void setAlarmHistory(ArrayList<String> alarmHistory) {
        this.alarmHistory = alarmHistory;
    }

	@Override
	public String toString() {
		return "VASAlarmHistory [firstAlarmTime=" + firstAlarmTime + ", roundHour=" + roundHour + ", maxInHr=" + maxInHr
				+ ", maxIn24Hr=" + maxIn24Hr + ", alarmHistory=" + alarmHistory + "]";
	}
}
