package com.oums.dao;

import com.oums.bean.vo.PaginationVo;
import com.oums.util.Pagination;
 
public interface IAccountDao {
	public Pagination getAccountFlows(PaginationVo paginationVo);	
}
