package com.oums.dao;

import java.util.List;

import com.oums.bean.po.OrderPo;

/**
 * 订单po操作
 * @author 谭治
 *
 */
public interface IOrderDao {

	/**
	 * 根据订单号查找订单
	 */
	OrderPo findOrderByNumber(String orderNumber);
	
	/**
	 * 根据订单号模糊查询
	 * @return
	 */
	List<OrderPo> findOrderLikeNumber(String orderNumber);
	
	/**
	 * 根据订单类型获取订单
	 * @return
	 */
	List<OrderPo> findOrderByClass(int orderClass);
	
	/**
	 * 根据订单状态获取订单
	 * @param orderType
	 * @return
	 */
	List<OrderPo> findOrderByType(int orderType);
	
	/**
	 * 根据订单状态获取订单
	 * @param orderType
	 * @return
	 */
	List<OrderPo> findOrderByTypeAndClass(int orderType, int orderClass);
	
	/**
	 * 按用户查找订单
	 * @param orderClass
	 * @return
	 */
	List<OrderPo> findOrderByUserAndClass(int userId, int orderClass);
}
