package com.oums.bean.po;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 场地表
 * @author 谭治
 *
 */
@Entity
@Table(name="t_site")
public class SitePo extends BasePo {

	private static final long serialVersionUID = 1L;
	/* 场地id */
	private Integer siteId;
	/* 场地名 */
	private String siteName;
	/* 场地类型 */
	private Integer siteType;
	/* 每小时费用 */
	private Float siteCost;
	/* 是否被删除 */
	private Boolean isDelete;
	/* 场地描述或备注 */
	private String siteDtail;
	/* 一周安排  */
	private WeekPo week;
	@OneToOne(optional=false, cascade={CascadeType.ALL}, fetch=FetchType.LAZY)
	@JoinColumn(name="weekId",unique=true)
	public WeekPo getWeek() {
		return week;
	}
	public void setWeek(WeekPo week) {
		this.week = week;
	}
	public SitePo() {
		super();
	}
	@Override
	public String toString() {
		return "SitePo [siteId=" + siteId + ", siteName=" + siteName + ", siteType=" + siteType + ", siteCost="
				+ siteCost + ", isDelete=" + isDelete + ", siteDtail=" + siteDtail + ", week=" + week + "]";
	}

	@Column(nullable = false)
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	@Id
	@GeneratedValue
	public Integer getSiteId() {
		return siteId;
	}
	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}
	public Integer getSiteType() {
		return siteType;
	}
	public void setSiteType(Integer siteType) {
		this.siteType = siteType;
	}
	public Float getSiteCost() {
		return siteCost;
	}
	public void setSiteCost(Float siteCost) {
		this.siteCost = siteCost;
	}
	public Boolean getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}
	public String getSiteDtail() {
		return siteDtail;
	}
	public void setSiteDtail(String siteDtail) {
		this.siteDtail = siteDtail;
	}
}
