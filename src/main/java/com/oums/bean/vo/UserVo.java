package com.oums.bean.vo;

public class UserVo extends BaseVo{

	private Integer userId;
	private String userName;
	private String password;
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
	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", userName=" + userName + ", password=" + password + "]";
	}
	public UserVo(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	public UserVo() {
		super();
		// TODO Auto-generated constructor stub
	}
}
