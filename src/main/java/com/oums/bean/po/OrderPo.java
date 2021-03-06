package com.oums.bean.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
	/* 备注 */
	private String remark;
	/* 回复 */
	private String reply;
	/* 用户 */
	private UserPo user;
	/* 操作的管理员 */
	private AdminUserPo adminUser;
	/* 场地 */
	private List<SitePo> siteList = new ArrayList<>();
	/* 赛事 */
	private RacePo race;
	/* 器材 */	
	private List<EquipmentPo> equipmentList = new ArrayList<>();
	@Override
	public String toString() {
		return "OrderPo [orderId=" + orderId + ", orderNumber=" + orderNumber + ", orderClass=" + orderClass
				+ ", orderType=" + orderType + ", buildTime=" + buildTime + ", isDelete=" + isDelete + ", remark="
				+ remark + ", reply=" + reply + ", user=" + user + ", adminUser=" + adminUser + ", siteList=" + siteList
				+ ", race=" + race + ", equipmentList=" + equipmentList + "]";
	}

	@ManyToMany(fetch=FetchType.LAZY)
	public List<EquipmentPo> getEquipmentList() {
		return equipmentList;
	}

	public void setEquipmentList(List<EquipmentPo> equipmentList) {
		this.equipmentList = equipmentList;
	}

	@ManyToOne(optional=true, fetch=FetchType.LAZY)
	@JoinColumn(name="adminUserId")
	public AdminUserPo getAdminUser() {
		return adminUser;
	}

	@OneToOne(optional=true, fetch=FetchType.LAZY)
	@JoinColumn(name="raceId")
	public RacePo getRace() {
		return race;
	}

	public void setRace(RacePo race) {
		this.race = race;
	}

	public void setAdminUser(AdminUserPo adminUser) {
		this.adminUser = adminUser;
	}
	
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}
	
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
	
	public OrderPo() {
		super();
	}
	
}
