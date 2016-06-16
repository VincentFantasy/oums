package com.oums.util;



import java.util.List;

public class Pagination extends SimplePage implements Paginable {

	public Pagination() {
	}

	public Pagination(int pageNo, int pageSize, int totalCount) {
		super(pageNo, pageSize, totalCount);
	}

	public Pagination(int pageNo, int pageSize, int totalCount, List<?> list) {
		super(pageNo, pageSize, totalCount);
		this.list = list;
	}

	public int getFirstResult() {
		return (pageNo - 1) * pageSize;
	}

	private List<?> list;

	public List<?> getList() {
		return list;
	}

	public void setList(@SuppressWarnings("rawtypes") List list) {
		this.list = list;
	}
}