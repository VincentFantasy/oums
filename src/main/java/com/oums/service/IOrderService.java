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
	
	/**
	 * 按订单号模糊查找订单 只匹配前面部分 number%
	 * @return
	 */
	ReturnMessage findOrderLikeNumber(OrderVo vo);
}
