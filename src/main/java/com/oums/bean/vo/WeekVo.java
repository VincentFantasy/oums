package com.oums.bean.vo;

import java.util.Arrays;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.oums.bean.po.DayPo;

public class WeekVo extends BaseVo {
	/* 场地id */
	private Integer weekId;
	/* 星期 */
	private DayPo sunday;
	private DayPo monday;
	private DayPo tuesday;
	private DayPo wednesday;
	private DayPo thurday;
	private DayPo friday;
	private DayPo saturday;
	
	public WeekVo(int init) {
		sunday = new DayPo(init);
		sunday.setDayOfWeek(0);
		monday = new DayPo(init);
		monday.setDayOfWeek(1);
		tuesday = new DayPo(init);
		tuesday.setDayOfWeek(2);
		wednesday = new DayPo(init);
		wednesday.setDayOfWeek(3);
		thurday = new DayPo(init);
		thurday.setDayOfWeek(4);
		friday = new DayPo(init);
		friday.setDayOfWeek(5);
		saturday = new DayPo(init);
		saturday.setDayOfWeek(6);
	}
	
	public WeekVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DayPo getSunday() {
		return sunday;
	}
	public void setSunday(DayPo sunday) {
		this.sunday = sunday;
	}
	public DayPo getMonday() {
		return monday;
	}
	public void setMonday(DayPo monday) {
		this.monday = monday;
	}
	public DayPo getTuesday() {
		return tuesday;
	}
	public void setTuesday(DayPo tuesday) {
		this.tuesday = tuesday;
	}
	public DayPo getWednesday() {
		return wednesday;
	}
	public void setWednesday(DayPo wednesday) {
		this.wednesday = wednesday;
	}
	public DayPo getThurday() {
		return thurday;
	}
	public void setThurday(DayPo thurday) {
		this.thurday = thurday;
	}
	public DayPo getFriday() {
		return friday;
	}
	public void setFriday(DayPo friday) {
		this.friday = friday;
	}
	public DayPo getSaturday() {
		return saturday;
	}
	public void setSaturday(DayPo saturday) {
		this.saturday = saturday;
	}
	@Override
	public String toString() {
		return "WeekPo [weekId=" + weekId + ", sunday=" + sunday + ", monday=" + monday + ", tuesday=" + tuesday
				+ ", wednesday=" + wednesday + ", thurday=" + thurday + ", friday=" + friday + ", saturday=" + saturday
				+ "]";
	}
	@Id
	@GeneratedValue
	public Integer getWeekId() {
		return weekId;
	}
	public void setWeekId(Integer weekId) {
		this.weekId = weekId;
	}
}
