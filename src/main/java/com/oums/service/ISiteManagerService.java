package com.oums.service;

import com.oums.bean.ReturnMessage;
import com.oums.bean.vo.SiteVo;

/**
 * 场地管理
 * @author 谭治
 */
public interface ISiteManagerService {
	
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
		
}
