package com.oums.bean.po;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * user表
 * @author Fantasy
 *
 */
@Entity
@Table(name="t_user")
public class UserPo extends BasePo {
	
	private static final long serialVersionUID = 1L;
	
	private Integer userId;
	// 用户名
	private String userName;
	// 密码
	private String password;
	// 真实姓名
	private String realName;
	// 身份证
	private String IDCardNumber;
	// 学号
	private String StudentNumber;
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
		return StudentNumber;
	}
	public void setStudentNumber(String studentNumber) {
		StudentNumber = studentNumber;
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserPo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserPo(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserPo [userId=" + userId + ", userName=" + userName + ", password=" + password + ", realName="
				+ realName + ", IDCardNumber=" + IDCardNumber + ", StudentNumber=" + StudentNumber + ", phone=" + phone
				+ ", lastLoginTime=" + lastLoginTime + ", isDelete=" + isDelete + "]";
	}
	
}
