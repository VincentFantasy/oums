package com.oums.bean;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

/**
 * 分页器 改成了自己的。。。
 * @author Fantasy
 *
 */
public class Page {   
	
	// 每页记录数 默认为 10
	private int pageSize = 10;

	// 当前页数
	private int pageNum = 1;

	// 记录总数，需要从数据库中查询出来
	private int recordCount;

	// 页数，根据 recordCount 与 pageSize 计算出来
	private int pageCount;


	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

//	public Page(HttpSession session) {
//
//		try{
//			pageNum = (int) session.getAttribute("pageNum");
//			pageSize = (int) session.getAttribute("pageSize");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//	}
	
	public Page(){
		
	}
	
	public Page(int recordCount){
		this.recordCount = recordCount;
		
		count();
	}
	
	public Page(int pageNum, int pageSize, int recordCount){
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.recordCount = recordCount;
		
		count();
	}
	
	public void count(){
		int i = recordCount % pageSize;
		if(i != 0)
			pageCount = recordCount / pageSize + 1;
		else
			pageCount = recordCount / pageSize;
	}

	@SuppressWarnings("rawtypes")
	public <T> List<T> thisPageData(List<T> list){
		List subList;
		int fromIndex;
		int toIndex;
		
		if(pageNum < pageCount){
		
			fromIndex = (pageNum - 1) * pageSize;
			toIndex = pageNum * pageSize;
		
			subList = list.subList(fromIndex, toIndex);
			
		} else if(pageNum == pageCount) {
			fromIndex = (pageNum - 1) * pageSize;
			toIndex = list.size();
			
			subList = list.subList(fromIndex, toIndex);
		} else {
			subList = new ArrayList<T>();
		}
		
		return subList;
	}
	
//	private void calculate() {
//		pageCount = (recordCount + pageSize - 1) / pageSize;
//		firstResult = (pageNum - 1) * pageSize;
//	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
		count();
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
} 
