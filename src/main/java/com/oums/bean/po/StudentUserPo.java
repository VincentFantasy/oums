package com.oums.bean.po;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "t_student_user")
public class StudentUserPo extends BasePo{
	private static final long serialVersionUID = 1L;
	
	private Integer userId;
//	// 用户名
//	private String userName;
	// 密码
	private String password;
	// 真实姓名
	private String realName;
	// 身份证
	private String IDCardNumber;
	// 学号
	private String studentNumber;
	// 联系电话
	private String phone;
	// 上次登陆时间
	private Date lastLoginTime;
	// 是否删除
	private Boolean isDelete;
	
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
	public String getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
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
	@Id
	@GeneratedValue
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
//	public String getUserName() {
//		return userName;
//	}
//	public void setUserName(String userName) {
//		this.userName = userName;
//	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public StudentUserPo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudentUserPo(String studentNumber, String password) {
		super();
		this.studentNumber = studentNumber;
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserPo [userId=" + userId + ", password=" + password + ", realName="
				+ realName + ", IDCardNumber=" + IDCardNumber + ", StudentNumber=" + studentNumber + ", phone=" + phone
				+ ", lastLoginTime=" + lastLoginTime + ", isDelete=" + isDelete + "]";
	}
}
