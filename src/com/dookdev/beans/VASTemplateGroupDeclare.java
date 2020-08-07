package com.dookdev.beans;

import java.util.Hashtable;

public class VASTemplateGroupDeclare {
	private String autoJob = "N";
	private String workHourStartTime;
	private String workHourEndTime;
	private String workHourResponseError;
	private String maxInTimeHr;
	private String maxInTimeHrResponseError;
	private String maxInTime24Hr;
	private String maxInTime24HrResponseError;
	private String expectTime;
	private Hashtable<String, String> varString;
	private Hashtable<String, Integer> varInt;

	public String getAutoJob() {
		return autoJob;
	}

	public void setAutoJob(String autoJob) {
		this.autoJob = autoJob;
	}

	public String getWorkHourStartTime() {
		return workHourStartTime;
	}

	public void setWorkHourStartTime(String workHourStartTime) {
		this.workHourStartTime = workHourStartTime;
	}

	public String getWorkHourEndTime() {
		return workHourEndTime;
	}

	public void setWorkHourEndTime(String workHourEndTime) {
		this.workHourEndTime = workHourEndTime;
	}

	public String getWorkHourResponseError() {
		return workHourResponseError;
	}

	public void setWorkHourResponseError(String workHourResponseError) {
		this.workHourResponseError = workHourResponseError;
	}

	public String getMaxInTimeHr() {
		return maxInTimeHr;
	}

	public void setMaxInTimeHr(String maxInTimeHr) {
		this.maxInTimeHr = maxInTimeHr;
	}

	public String getMaxInTimeHrResponseError() {
		return maxInTimeHrResponseError;
	}

	public void setMaxInTimeHrResponseError(String maxInTimeHrResponseError) {
		this.maxInTimeHrResponseError = maxInTimeHrResponseError;
	}

	public String getMaxInTime24Hr() {
		return maxInTime24Hr;
	}

	public void setMaxInTime24Hr(String maxInTime24Hr) {
		this.maxInTime24Hr = maxInTime24Hr;
	}

	public String getMaxInTime24HrResponseError() {
		return maxInTime24HrResponseError;
	}

	public void setMaxInTime24HrResponseError(String maxInTime24HrResponseError) {
		this.maxInTime24HrResponseError = maxInTime24HrResponseError;
	}

	public String getExpectTime() {
		return expectTime;
	}

	public void setExpectTime(String expectTime) {
		this.expectTime = expectTime;
	}

	public Hashtable<String, String> getVarString() {
		return varString;
	}

	public void setVarString(Hashtable<String, String> varString) {
		this.varString = varString;
	}

	public Hashtable<String, Integer> getVarInt() {
		return varInt;
	}

	public void setVarInt(Hashtable<String, Integer> varInt) {
		this.varInt = varInt;
	}

	@Override
	public String toString() {
		return "VASTemplateGroupDeclare [autoJob=" + autoJob + ", workHourStartTime=" + workHourStartTime
				+ ", workHourEndTime=" + workHourEndTime + ", workHourResponseError=" + workHourResponseError
				+ ", maxInTimeHr=" + maxInTimeHr + ", maxInTimeHrResponseError=" + maxInTimeHrResponseError
				+ ", maxInTime24Hr=" + maxInTime24Hr + ", maxInTime24HrResponseError=" + maxInTime24HrResponseError
				+ ", expectTime=" + expectTime + ", varString=" + varString + ", varInt=" + varInt + "]";
	}

}
