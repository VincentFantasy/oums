package com.oums.bean.vo;


import java.util.Date;

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

public class EquipmentVo extends BaseVo{
	
	/*器材ID*/
	private String  equipId;
	/*器材名称*/
	private String equipName;
	/*器品牌名称*/
	private String equipBrand;
	/*器材收购价格*/
	private Float equipPrice;
	/*器材出租价格*/
	private Float rentPrice;
	/* 器材描述或备注 */
	private String equipDtail;
	/* 器材数量 */
	private Integer equipNum;
	/*器材添加时间*/
	private Date addTime;
	
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	public Integer getEquipNum() {
		return equipNum;
	}
	public void setEquipNum(Integer equipNum) {
		this.equipNum = equipNum;
	}
	public String getEquipId() {
		return equipId;
	}
	public String getEquipName() {
		return equipName;
	}
	public Float getRentPrice() {
		return rentPrice;
	}
	public String getEquipBrand() {
		return equipBrand;
	}
	public Float getEquipPrice() {
		return equipPrice;
	}
	public String getEquipDtail() {
		return equipDtail;
	}
	public void setEquipBrand(String equipBrand) {
		this.equipBrand = equipBrand;
	}
	public void setEquipPrice(Float equipPrice) {
		this.equipPrice = equipPrice;
	}
	public void setEquipDtail(String equipDtail) {
		this.equipDtail = equipDtail;
	}

	
	public void setRentPrice(Float rentPrice) {
		this.rentPrice = rentPrice;
	}
	
	public void setEquipId(String equipId) {
		this.equipId = equipId;
	}
	public void setEquipName(String equipName) {
		this.equipName = equipName;
	}
	
}
