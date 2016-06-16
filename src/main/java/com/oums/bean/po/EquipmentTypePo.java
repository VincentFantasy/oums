package com.oums.bean.po;

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
@Entity
@Table(name="t_equipmentType")
public class EquipmentTypePo extends BasePo{
	
	private static final long serialVersionUID = 1L;

	/*器材种类ID*/
	private Integer  equipTypeId;
	/*器材名称*/
	private String equipName; 
	/*品牌名称*/
	private String equipBrand; 
	/*器材可借数量*/
	private Integer equipNum;
	/*器材租借价格*/
	private Float rentPrice;
	/*器材价格*/
	private Float equipPrice;
	
	@Id
	@GeneratedValue
	public Integer getEquipTypeId() {
		return equipTypeId;
	}
	public String getEquipName() {
		return equipName;
	}
	
	public Float getEquipPrice() {
		return equipPrice;
	}
	public void setEquipPrice(Float equipPrice) {
		this.equipPrice = equipPrice;
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
	public void setEquipTypeId(Integer equipTypeId) {
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
