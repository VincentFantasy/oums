package com.oums.bean.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 订单表，需要加东西的说下
 * @author 谭治
 *
 */
@Entity
@Table(name="t_order")
public class OrderPo extends BasePo {
	
	private static final long serialVersionUID = 1L;
	
	/* id */
	private Integer orderId;
	/* 订单号 */
	private String orderNumber;
	/* 订单类型 */
	private Integer orderClass;
	/* 订单状态 */
	private Integer orderType;
	/* 订单生成时间 */
	private Date buildTime;
	/* 是否删除  */
	private Boolean isDelete;
	/* 用户 */
	private UserPo user;
	/* 场地 */
	private List<SitePo> siteList = new ArrayList<>();
	/* 赛事 */
//	private List<RacePo> raceList = new ArrayList<>();
	/* 还要加管理员的Po */
	
	@Id
	@GeneratedValue
	public Integer getOrderId() {
		return orderId;
	}
	
	public Integer getOrderClass() {
		return orderClass;
	}

	public void setOrderClass(Integer orderClass) {
		this.orderClass = orderClass;
	}

	public Integer getOrderType() {
		return orderType;
	}

	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Boolean getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public Date getBuildTime() {
		return buildTime;
	}
	public void setBuildTime(Date buildTime) {
		this.buildTime = buildTime;
	}
	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JoinColumn(name="userId")
	public UserPo getUser() {
		return user;
	}
	public void setUser(UserPo user) {
		this.user = user;
	}
	@ManyToMany(fetch=FetchType.LAZY)
	public List<SitePo> getSiteList() {
		return siteList;
	}
	public void setSiteList(List<SitePo> siteList) {
		this.siteList = siteList;
	}
	@Override
	public String toString() {
		return "OrderPo [orderId=" + orderId + ", orderNumber=" + orderNumber + ", orderClass=" + orderClass
				+ ", orderType=" + orderType + ", buildTime=" + buildTime + ", isDelete=" + isDelete + ", user=" + user
				+ ", siteList=" + siteList + "]";
	}
	public OrderPo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
