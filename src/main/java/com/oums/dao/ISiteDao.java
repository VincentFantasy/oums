package com.oums.dao;

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
	
}
