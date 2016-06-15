package com.oums.bean.vo;

import java.util.Date;

public class GonggaoVo extends BaseVo {

	private Integer gonggaoId;
	/* 名 */
	private String gonggaoTitile;
	/* 是否被删除 */
	private Boolean isDelete;
	/* 场地描述或备注 */
	private String gonggaoDtail;
	/* */
	private Date buildTime;
	public Date getBuildTime() {
		return buildTime;
	}
	public void setBuildTime(Date buildTime) {
		this.buildTime = buildTime;
	}
	@Override
	public String toString() {
		return "GonggaoVo [gonggaoId=" + gonggaoId + ", gonggaoTitile=" + gonggaoTitile + ", isDelete=" + isDelete
				+ ", gonggaoDtail=" + gonggaoDtail + ", buildTime=" + buildTime + "]";
	}
	public Integer getGonggaoId() {
		return gonggaoId;
	}
	public void setGonggaoId(Integer gonggaoId) {
		this.gonggaoId = gonggaoId;
	}
	public String getGonggaoTitile() {
		return gonggaoTitile;
	}
	public void setGonggaoTitile(String gonggaoTitile) {
		this.gonggaoTitile = gonggaoTitile;
	}
	public Boolean getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}
	public String getGonggaoDtail() {
		return gonggaoDtail;
	}
	public void setGonggaoDtail(String gonggaoDtail) {
		this.gonggaoDtail = gonggaoDtail;
	}
}
