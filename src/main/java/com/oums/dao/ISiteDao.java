package com.oums.dao;

import java.util.List;

import com.oums.bean.po.SitePo;

/**
 * 
 * @author 谭治
 *
 */
public interface ISiteDao {

	/**
	 * 根据场地名获取场地
	 * @return
	 */
	SitePo findSitePoBySiteName(String siteName);
	
	/**
	 * 根据场地类型获取场地
	 * @param type
	 * @return
	 */
	List<SitePo> findSitePoBySiteType(int type);
	
}
