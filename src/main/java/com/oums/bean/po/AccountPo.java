package com.oums.bean.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "t_account")
public class AccountPo extends BasePo{
	/**
	 * 收入
	 * 类别
	 * 1,场地租凭
	 * 2,器材租凭
	 * 3,学校拨款
	 * 
	 * 支出
	 * 类别
	 * 1,场地维护
	 * 2,器材购买
	 * 3,员工支出
	 */
	@Id
	@GeneratedValue
	private Integer accountId;
	private String flow_type;
	private String flow_detail;
	private Double flow_account;
	private Double account_balance;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createTime", length = 19)
	private Date time;
	@Column(name = "isDelete")
	@Type(type="boolean")
	private boolean isDelete;
	public boolean isDelete() {
		return isDelete;
	}
	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}
	public Integer getFinanceId() {
		return accountId;
	}
	public void setFinanceId(Integer financeId) {
		this.accountId = financeId;
	}
	public String getFlow_type() {
		return flow_type;
	}
	public void setFlow_type(String flow_type) {
		this.flow_type = flow_type;
	}
	public String getFlow_detail() {
		return flow_detail;
	}
	public void setFlow_detail(String flow_detail) {
		this.flow_detail = flow_detail;
	}
	public Double getFlow_account() {
		return flow_account;
	}
	public void setFlow_account(Double flow_account) {
		this.flow_account = flow_account;
	}
	public Double getAccount_balance() {
		return account_balance;
	}
	public void setAccount_balance(Double account_balance) {
		this.account_balance = account_balance;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
}
