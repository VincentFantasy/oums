package com.oums.service;

import com.oums.bean.ReturnMessage;

/**
 * 场地服务
 * @author 谭治
 *
 */
public interface ISiteService {

	/**
	 * 根据名字查找场地
	 * @return
	 */
	ReturnMessage findSiteByName(String siteName);
	
	/**
	 * 更改场地是否使用
	 * @return
	 */
	ReturnMessage updataSiteUsingByName(String siteName);
	
}
