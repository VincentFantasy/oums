package com.oums.service;

import com.oums.bean.ReturnMessage;
import com.oums.bean.vo.SiteVo;

/**
 * 场地服务
 * @author 谭治
 *
 */
public interface ISiteService {

	/**
	 * 添加场地
	 * @return
	 */
	ReturnMessage addSite(SiteVo vo);
	
	/**
	 * 删除场地(改变isDelete状态，不是真正删除)
	 * @return
	 */
	ReturnMessage deleteSite(SiteVo vo);
	
	/**
	 * 更新场地
	 * @return
	 */
	ReturnMessage updateSite(SiteVo vo);
	
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
