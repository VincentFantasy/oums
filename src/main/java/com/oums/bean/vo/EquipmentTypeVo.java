package com.oums.bean.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 器材种类类
 * @author pzh
 * TODO
 * 2016年6月4日
 */

public class EquipmentTypeVo extends BaseVo{
	

	/*器材种类ID*/
	private String  equipTypeId;
	/*器材名称*/
	private String equipName; 
	/*品牌名称*/
	private String equipBrand; 
	/*器材可借数量*/
	private Integer equipNum;
	/*器材租借价格*/
	private Float rentPrice;
	/*租借天数*/
	private Integer day;
	/*租借小时*/
	private Integer hour;
	

	public Integer getDay() {
		return day;
	}
	public Integer getHour() {
		return hour;
	}
	public void setDay(Integer day) {
		this.day = day;
	}
	public void setHour(Integer hour) {
		this.hour = hour;
	}
	public String getEquipTypeId() {
		return equipTypeId;
	}
	public String getEquipName() {
		return equipName;
	}
	public String getEquipBrand() {
		return equipBrand;
	}
	public Integer getEquipNum() {
		return equipNum;
	}
	public Float getRentPrice() {
		return rentPrice;
	}
	public void setEquipTypeId(String equipTypeId) {
		this.equipTypeId = equipTypeId;
	}
	public void setEquipName(String equipName) {
		this.equipName = equipName;
	}
	public void setEquipBrand(String equipBrand) {
		this.equipBrand = equipBrand;
	}
	public void setEquipNum(Integer equipNum) {
		this.equipNum = equipNum;
	}
	public void setRentPrice(Float rentPrice) {
		this.rentPrice = rentPrice;
	}

	
	
	
	
}
