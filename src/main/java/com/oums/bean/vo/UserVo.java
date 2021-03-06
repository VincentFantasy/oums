package com.oums.bean.vo;

import java.util.Date;

public class UserVo extends BaseVo{

		private Integer userId;

		// 密码
		private String password;
		// 真实姓名
		private String realName;
		// 身份证
		private String IDCardNumber;
		// 证件号
		private String certificateNumber;
		// 联系电话
		private String phone;
		// 上次登陆时间
		private Date lastLoginTime;
		// 是否删除
		private Boolean isDelete;
		// 入学年份
		private String period;
		// 班级
		private String classes;
		//是否游客
		private Boolean isTourist;


		public Integer getUserId() {
			return userId;
		}
		public void setUserId(Integer userId) {
			this.userId = userId;
		}

    	@Override
		public String toString() {
			return "UserVo [userId=" + userId + ", password=" + password + ", realName=" + realName + ", IDCardNumber="
					+ IDCardNumber + ", certificateNumber=" + certificateNumber + ", phone=" + phone
					+ ", lastLoginTime=" + lastLoginTime + ", isDelete=" + isDelete + "]";
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
		public String getCertificateNumber() {
			return certificateNumber;
		}
		public void setCertificateNumber(String certificateNumber) {
			this.certificateNumber = certificateNumber;
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
		public String getPeriod() {
			return period;
		}
		public void setPeriod(String period) {
			this.period = period;
		}
		public String getClasses() {
			return classes;
		}
		public void setClasses(String classes) {
			this.classes = classes;
		}
		public Boolean getIsTourist() {
			return isTourist;
		}
		public void setIsTourist(Boolean isTourist) {
			this.isTourist = isTourist;
		}
		
	}

