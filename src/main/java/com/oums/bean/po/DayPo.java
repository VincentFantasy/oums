package com.oums.bean.po;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_day")
public class DayPo extends BasePo {

	private static final long serialVersionUID = 1L;
	/* 场地id */
	private Integer dayId;
	/* 星期几 0日 1一 */
	private Integer dayOfWeek;
	/* 每天的时间段 填ItemState */
	private Integer time0;
	private Integer time1;
	private Integer time2;
	private Integer time3;
	private Integer time4;
	private Integer time5;
	
	public DayPo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DayPo(int init) {
		time0 = init;
		time1 = init;
		time2 = init;
		time3 = init;
		time4 = init;
		time5 = init;
	}
	
	@Id
	@GeneratedValue
	public Integer getDayId() {
		return dayId;
	}
	public void setDayId(Integer dayId) {
		this.dayId = dayId;
	}
	public Integer getDayOfWeek() {
		return dayOfWeek;
	}
	public void setDayOfWeek(Integer dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	public Integer getTime0() {
		return time0;
	}
	public void setTime0(Integer time0) {
		this.time0 = time0;
	}
	public Integer getTime1() {
		return time1;
	}
	public void setTime1(Integer time1) {
		this.time1 = time1;
	}
	public Integer getTime2() {
		return time2;
	}
	public void setTime2(Integer time2) {
		this.time2 = time2;
	}
	public Integer getTime3() {
		return time3;
	}
	public void setTime3(Integer time3) {
		this.time3 = time3;
	}
	public Integer getTime4() {
		return time4;
	}
	public void setTime4(Integer time4) {
		this.time4 = time4;
	}
	public Integer getTime5() {
		return time5;
	}
	public void setTime5(Integer time5) {
		this.time5 = time5;
	}
	@Override
	public String toString() {
		return "DayPo [dayId=" + dayId + ", dayOfWeek=" + dayOfWeek + ", time0=" + time0 + ", time1=" + time1
				+ ", time2=" + time2 + ", time3=" + time3 + ", time4=" + time4 + ", time5=" + time5 + "]";
	}
}
