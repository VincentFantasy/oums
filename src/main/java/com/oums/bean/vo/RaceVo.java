package com.oums.bean.vo;

public class RaceVo extends BaseVo{

	/* 场地id */
	private Integer raceId;
	/* 场地名 */
	private String raceName;
	/* 赛事时间，用string值，如 2016年6月1号 */
	private String siteTime;
	/* 是否被删除 */
	private Boolean isDelete;
	/* 赛事描述或备注 */
	private String raceDtail;
	public Integer getRaceId() {
		return raceId;
	}
	public void setRaceId(Integer raceId) {
		this.raceId = raceId;
	}
	public String getRaceName() {
		return raceName;
	}
	public void setRaceName(String raceName) {
		this.raceName = raceName;
	}
	public String getSiteTime() {
		return siteTime;
	}
	public void setSiteTime(String siteTime) {
		this.siteTime = siteTime;
	}
	public Boolean getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}
	public String getRaceDtail() {
		return raceDtail;
	}
	public void setRaceDtail(String raceDtail) {
		this.raceDtail = raceDtail;
	}
	@Override
	public String toString() {
		return "RaceVo [raceId=" + raceId + ", raceName=" + raceName + ", siteTime=" + siteTime + ", isDelete="
				+ isDelete + ", raceDtail=" + raceDtail + "]";
	}
	
}
