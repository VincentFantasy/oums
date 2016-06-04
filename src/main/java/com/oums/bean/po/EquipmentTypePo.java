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
@Table(name="t_equipmentOrderItem")
public class EquipmentTypePo extends BasePo{
	
	private static final long serialVersionUID = 1L;
	
	/*器材ID*/
	private String  equipId;
	/*器材种类ID*/
	private String  equipTypeId;
	/*器材名称*/
	private String equipName; 
	/*器材租借数量*/
	private Integer rentNum;
	/*器材租借价格*/
	private Float rentPrice;
	/*器材状态*/
	private Integer itemState;
	
	@Id
	@GeneratedValue
	public String getEquipId() {
		return equipId;
	}
	public String getEquipTypeId() {
		return equipTypeId;
	}
	public String getEquipName() {
		return equipName;
	}
	public Integer getRentNum() {
		return rentNum;
	}
	public Float getRentPrice() {
		return rentPrice;
	}
	public Integer getItemState() {
		return itemState;
	}
	public void setEquipId(String equipId) {
		this.equipId = equipId;
	}
	public void setEquipTypeId(String equipTypeId) {
		this.equipTypeId = equipTypeId;
	}
	public void setEquipName(String equipName) {
		this.equipName = equipName;
	}
	public void setRentNum(Integer rentNum) {
		this.rentNum = rentNum;
	}
	public void setRentPrice(Float rentPrice) {
		this.rentPrice = rentPrice;
	}
	public void setItemState(Integer itemState) {
		this.itemState = itemState;
	}
	
	
}
