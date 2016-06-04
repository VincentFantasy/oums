package com.oums.bean.po;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 器材类,也是订单类
 * @author pzh
 * TODO
 * 2016年6月4日
 */
@Entity
@Table(name="t_equipment")
public class EquipmentPo extends BasePo{
	
	private static final long serialVersionUID = 1L;
	
	/*器材种类ID*/
	private String  equipTypeId; 
	/*器材名称*/
	private String equipName; 
	/*器材总数量*/
	private String totalNum; 
	/*器材剩余数量*/
	private String leftNum;
	/*器材收购价格*/
	private Float price;
	/* 器材描述或备注 */
	private String equipDtail;
	
	
	@Override
	public String toString() {
		return "EquipmentPo [equipId=" + equipTypeId + ", equipName=" + equipName + ", totalNum=" + totalNum + ", leftNum="
				+ leftNum +", price=" + price + "]";
	}

	@Id
	@GeneratedValue
	public String getEquipTypeId() {
		return equipTypeId;
	}


	public String getEquipName() {
		return equipName;
	}


	public String getTotalNum() {
		return totalNum;
	}


	public String getLeftNum() {
		return leftNum;
	}


	public Float getPrice() {
		return price;
	}


	public void setEquipTypeId(String equipTypeId) {
		this.equipTypeId = equipTypeId;
	}


	public void setEquipName(String equipName) {
		this.equipName = equipName;
	}


	public void setTotalNum(String totalNum) {
		this.totalNum = totalNum;
	}


	public void setLeftNum(String leftNum) {
		this.leftNum = leftNum;
	}


	public void setPrice(Float price) {
		this.price = price;
	}
	
}
