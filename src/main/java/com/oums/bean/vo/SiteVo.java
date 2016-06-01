package com.oums.bean.vo;

/**
 * siteVo
 * @author 谭治
 *
 */
public class SiteVo extends BaseVo{
	/* 场地id */
	private Integer siteId;
	/* 场地名 */
	private String siteName;
	/* 场地类型 */
	private Integer siteType;
	/* 每小时费用 */
	private Float siteCost;
	/* 是否被占用 */
	private Integer itemState;
	/* 是否被删除 */
	private Boolean isDelete;
	/* 场地描述或备注 */
	private String siteDtail;

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

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

	@Override
	public String toString() {
		return "SiteVo [siteId=" + siteId + ", siteName=" + siteName + ", siteType=" + siteType + ", siteCost="
				+ siteCost + ", itemState=" + itemState + ", isDelete=" + isDelete + ", siteDtail=" + siteDtail + "]";
	}

	public Integer getItemState() {
		return itemState;
	}

	public void setItemState(Integer itemState) {
		this.itemState = itemState;
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

	public SiteVo() {
		super();
		// TODO Auto-generated constructor stub
	}
}
