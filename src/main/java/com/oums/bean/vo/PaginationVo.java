package com.oums.bean.vo;


/**
 * 分页信息vo
 * @author 油芯
 *
 */
public class PaginationVo extends BaseVo{
	private int pageSize;
	private int pageNo;
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	} 
	
}
