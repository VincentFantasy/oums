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
@Table(name="t_siteType")
public class SiteTypePo extends BasePo {

	private static final long serialVersionUID = 1L;
	/* 场地id */
	private Integer siteTypeId;
	/* 场地类型名 */
	private String siteTypeName;
	/* 是否删除 */
	private Boolean isDelete;
	
	public Boolean getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}
	@Override
	public String toString() {
		return "SiteTypePo [siteTypeId=" + siteTypeId + ", siteTypeName=" + siteTypeName + ", isDelete=" + isDelete
				+ "]";
	}
	@Id
	@GeneratedValue
	public Integer getSiteTypeId() {
		return siteTypeId;
	}
	public void setSiteTypeId(Integer siteTypeId) {
		this.siteTypeId = siteTypeId;
	}
	public String getSiteTypeName() {
		return siteTypeName;
	}
	public void setSiteTypeName(String siteTypeName) {
		this.siteTypeName = siteTypeName;
	}

}
