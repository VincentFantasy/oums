package com.oums.bean.vo;

import java.util.Arrays;

public class WeekVo extends BaseVo {
	private static final long serialVersionUID = 1L;
	/* 场地id */
	private Integer weekId;
	/* 每天的时间段 填ItemState */
	private Integer monday[] = new Integer[6];
	private Integer tuesday[] = new Integer[6];
	private Integer wednesday[] = new Integer[6];
	private Integer thurday[] = new Integer[6];
	private Integer friday[] = new Integer[6];
	private Integer saturday[] = new Integer[6];
	private Integer sunday[] = new Integer[6];
	public Integer getWeekId() {
		return weekId;
	}
	public void setWeekId(Integer weekId) {
		this.weekId = weekId;
	}
	public Integer[] getMonday() {
		return monday;
	}
	public void setMonday(Integer[] monday) {
		this.monday = monday;
	}
	public Integer[] getTuesday() {
		return tuesday;
	}
	public void setTuesday(Integer[] tuesday) {
		this.tuesday = tuesday;
	}
	public Integer[] getWednesday() {
		return wednesday;
	}
	public void setWednesday(Integer[] wednesday) {
		this.wednesday = wednesday;
	}
	public Integer[] getThurday() {
		return thurday;
	}
	public void setThurday(Integer[] thurday) {
		this.thurday = thurday;
	}
	public Integer[] getFriday() {
		return friday;
	}
	public void setFriday(Integer[] friday) {
		this.friday = friday;
	}
	public Integer[] getSaturday() {
		return saturday;
	}
	public void setSaturday(Integer[] saturday) {
		this.saturday = saturday;
	}
	public Integer[] getSunday() {
		return sunday;
	}
	public void setSunday(Integer[] sunday) {
		this.sunday = sunday;
	}
	public WeekVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public WeekVo(int init) {
		for(int i = 0; i < monday.length; i++) {
			monday[i] = init;
			tuesday[i] = init;
			wednesday[i] = init;
			thurday[i] = init;
			friday[i] = init;
			saturday[i] = init;
			sunday[i] = init;
		}
	}
	@Override
	public String toString() {
		return "WeekPo [weekId=" + weekId + ", monday=" + Arrays.toString(monday) + ", tuesday="
				+ Arrays.toString(tuesday) + ", wednesday=" + Arrays.toString(wednesday) + ", thurday="
				+ Arrays.toString(thurday) + ", friday=" + Arrays.toString(friday) + ", saturday="
				+ Arrays.toString(saturday) + ", sunday=" + Arrays.toString(sunday) + "]";
	}
	
}
