package com.oums.service;

import com.oums.bean.ReturnMessage;
import com.oums.bean.vo.AdminUserVo;
import com.oums.bean.vo.DayVo;
import com.oums.bean.vo.OrderVo;
import com.oums.bean.vo.SiteVo;
import com.oums.bean.vo.WeekVo;

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
	 * 更新场地信息
	 * @return
	 */
	ReturnMessage updateSite(SiteVo vo);
	
	/**
	 * 改变场地状态
	 * @param vo
	 * @return
	 */
	ReturnMessage updateSiteType(SiteVo vo, WeekVo weekVo, DayVo dayVo);
	
	/**
	 * 获取全部场地的信息
	 * @return
	 */
	ReturnMessage findAllSiteOrder();
	
	/**
	 * 根据订单号改变订单状态
	 * @param vo
	 * @param adminUserVo
	 * @param state
	 * @return
	 */
	ReturnMessage updateSiteOrderStateByNumber(OrderVo vo, AdminUserVo adminUserVo, int state);
	
	/**
	 * 根据订单状态获取订单
	 * @param vo
	 * @return
	 */
	ReturnMessage findSiteOrderByType(OrderVo vo);
}
