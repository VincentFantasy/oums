package com.oums.bean.po;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * type of permission
 * @author Zhenghui Ou
 *
 */
@Entity
@Table(name = "t_type")
public class TypePo extends BasePo{
	
	private static final long serialVersionUID = 1L;
	//权限表号
	private Integer typeId;
	//员工号
	private String employeeNumber;
	//权限码
	private int permission;
	
	public String getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public int getPermission() {
		return permission;
	}

	public void setPermission(int permission) {
		this.permission = permission;
	}
	@Id
	@GeneratedValue
	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
}
