package com.oums.bean.vo;

import java.util.Date;

public class AdminUserVo extends BaseVo{
	private Integer userId;
	// 密码
	private String password;
	// 真实姓名
	private String realName;
	// 身份证
	private String IDCardNumber;
	// 员工号
	private String employeeNumber;
	// 联系电话
	private String phone;
	// 上次登陆时间
	private Date lastLoginTime;
	// 是否删除
	private Boolean isDelete;
	//权限
	private int permission;
	
	public int getPermission() {
		return permission;
	}
	public void setPermission(int permission) {
		this.permission = permission;
	}
	public AdminUserVo(String employeeNumber, String password) {
		super();
		this.employeeNumber = employeeNumber;
		this.password = password;
	}
	public AdminUserVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override 
	 public String toString() { 

	 return "\"permission\" : " + "\"" + permission + "\"" + "," 
	 + "\"userId\" : " + "\"" + userId + "\"" + "," 
	 + "\"password\" : " + "\"" + password + "\"" + "," 
	 + "\"realName\" : " + "\"" + realName + "\"" + "," 
	 + "\"IDCardNumber\" : " + "\"" + IDCardNumber + "\"" + "," 
	 + "\"isDelete\" : " + "\"" + isDelete + "\"" + "," 
	 + "\"employeeNumber\" : " + "\"" + employeeNumber + "\"" + "," 
	 + "\"phone\" : " + "\"" + phone + "\"" + "," 
	 + "\"lastLoginTime\" : " + "\"" + lastLoginTime + "\""; 
	 } 

	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getIDCardNumber() {
		return IDCardNumber;
	}
	public void setIDCardNumber(String iDCardNumber) {
		IDCardNumber = iDCardNumber;
	}
	public String getEmployeeNumber() {
		return employeeNumber;
	}
	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public Boolean getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}
}
