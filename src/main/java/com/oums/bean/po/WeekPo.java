package com.oums.bean.po;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 一周安排表
 * @author 谭治
 *
 */
@Entity
@Table(name="t_week")
public class WeekPo extends BasePo {

	private static final long serialVersionUID = 1L;
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
	
	public WeekPo(int init) {
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
	
	public WeekPo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@OneToOne(optional=false, cascade={CascadeType.ALL}, fetch=FetchType.LAZY)
	@JoinColumn(name="sundayId",unique=true)
	public DayPo getSunday() {
		return sunday;
	}
	public void setSunday(DayPo sunday) {
		this.sunday = sunday;
	}
	@OneToOne(optional=false, cascade={CascadeType.ALL}, fetch=FetchType.LAZY)
	@JoinColumn(name="mondayId",unique=true)
	public DayPo getMonday() {
		return monday;
	}
	public void setMonday(DayPo monday) {
		this.monday = monday;
	}
	@OneToOne(optional=false, cascade={CascadeType.ALL}, fetch=FetchType.LAZY)
	@JoinColumn(name="tuesdayId",unique=true)
	public DayPo getTuesday() {
		return tuesday;
	}
	public void setTuesday(DayPo tuesday) {
		this.tuesday = tuesday;
	}
	@OneToOne(optional=false, cascade={CascadeType.ALL}, fetch=FetchType.LAZY)
	@JoinColumn(name="wednesdayId",unique=true)
	public DayPo getWednesday() {
		return wednesday;
	}
	public void setWednesday(DayPo wednesday) {
		this.wednesday = wednesday;
	}
	@OneToOne(optional=false, cascade={CascadeType.ALL}, fetch=FetchType.LAZY)
	@JoinColumn(name="thurdayId",unique=true)
	public DayPo getThurday() {
		return thurday;
	}
	public void setThurday(DayPo thurday) {
		this.thurday = thurday;
	}
	@OneToOne(optional=false, cascade={CascadeType.ALL}, fetch=FetchType.LAZY)
	@JoinColumn(name="fridayId",unique=true)
	public DayPo getFriday() {
		return friday;
	}
	public void setFriday(DayPo friday) {
		this.friday = friday;
	}
	@OneToOne(optional=false, cascade={CascadeType.ALL}, fetch=FetchType.LAZY)
	@JoinColumn(name="saturdayId",unique=true)
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
