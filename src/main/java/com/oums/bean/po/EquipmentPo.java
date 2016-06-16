package com.oums.bean.po;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 器材,订单项: 器材ID,名字,状态,
 * @author pzh
 * TODO
 * 2016年6月4日
 */
@Entity
@Table(name="t_equipmentItem")
public class EquipmentPo extends BasePo{
	
	private static final long serialVersionUID = 1L;
	
	/*器材ID*/
	private Integer  equipId;
	/*器材zhongleiID*/
	private Integer  equipTypeId;
	
	/*器材名称*/
	private String equipName;
	/*器品牌名称*/
	private String equipBrand;
	/*器材状态*/
	private Integer itemState;
	/* 是否被删除 */
	private Integer isDelete; 
	/*器材收购价格*/
	private Float equipPrice;
	/*器材出租价格*/
	private Float rentPrice;
	/* 器材描述或备注 */
	private String equipDtail;
	/*添加时间*/
	private Date addTime;
	
	@Id
	@GeneratedValue
	public Integer getEquipId() {
		return equipId;
	}
	public String getEquipName() {
		return equipName;
	}
	public Integer getItemState() {
		return itemState;
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
	public Integer getIsDelete() {
		return isDelete;
	}
	public Date getAddTime() {
		return addTime;
	}
	public Integer getEquipTypeId() {
		return equipTypeId;
	}
	public void setEquipTypeId(Integer equipTypeId) {
		this.equipTypeId = equipTypeId;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
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
	
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	public void setEquipId(Integer equipId) {
		this.equipId = equipId;
	}
	public void setEquipName(String equipName) {
		this.equipName = equipName;
	}
	public void setItemState(Integer itemState) {
		this.itemState = itemState;
	}
	
	
}
