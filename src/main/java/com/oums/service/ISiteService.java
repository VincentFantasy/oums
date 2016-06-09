package com.oums.service;

import com.oums.bean.ReturnMessage;
import com.oums.bean.po.OrderPo;
import com.oums.bean.po.SitePo;
import com.oums.bean.po.UserPo;
import com.oums.bean.vo.OrderVo;
import com.oums.bean.vo.SiteVo;

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
	 * 根据类型返回场地
	 * @param siteType
	 * @return
	 */
	ReturnMessage findSiteByType(int siteType);
	
	/**
	 * 预约场地
	 * @return
	 */
	ReturnMessage addSiteOrder(OrderVo vo, SitePo sitePo);
	
	/**
	 * 查找此场地的周表
	 * @param vo
	 * @return
	 */
	ReturnMessage findWeekBySite(SiteVo vo);
	
	/**
	 * 查找 用户自己的订单
	 * @param user
	 * @return
	 */
	ReturnMessage findUserOrder(UserPo user);
	
	/**
	 * 改变场地订单状态，如付款，取消等
	 * @return
	 */
	ReturnMessage updateSiteOrder(OrderPo po);
}
