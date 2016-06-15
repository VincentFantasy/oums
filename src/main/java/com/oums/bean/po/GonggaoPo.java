package com.oums.bean.po;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 场地表
 * @author 谭治
 *
 */
@Entity
@Table(name="t_gonggao")
public class GonggaoPo extends BasePo {

	private static final long serialVersionUID = 1L;
	/* id */
	private Integer gonggaoId;
	/* 名 */
	private String gonggaoTitile;
	/* 是否被删除 */
	private Boolean isDelete;
	/* 场地描述或备注 */
	private String gonggaoDtail;
	/* 建立时间 */
	private Date buildTime;
	public Date getBuildTime() {
		return buildTime;
	}
	public void setBuildTime(Date buildTime) {
		this.buildTime = buildTime;
	}
	@Override
	public String toString() {
		return "GonggaoPo [gonggaoId=" + gonggaoId + ", gonggaoTitile=" + gonggaoTitile + ", isDelete=" + isDelete
				+ ", gonggaoDtail=" + gonggaoDtail + "]";
	}
	@Id
	@GeneratedValue
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
