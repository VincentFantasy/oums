package com.oums.service;

import com.oums.bean.ReturnMessage;
import com.oums.bean.vo.OrderVo;

/**
 * 订单通用服务
 * @author 谭治
 *
 */
public interface IOrderService {

	/**
	 * 按订单号查找订单
	 * @return
	 */
	ReturnMessage findOrderByNumber(OrderVo vo);
	
}
