package com.oums.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.oums.bean.ReturnMessage;
import com.oums.bean.vo.OrderVo;
import com.oums.service.IOrderService;

/**
 * 
 * @author Fantasy
 *
 */
@ParentPackage("basePackage")
@Namespace("/jsp/order")
public class OrderAction {
	
	@Autowired
	IOrderService orderService;
	
	private ReturnMessage returnMessage;
	
	private OrderVo order;

	public ReturnMessage getReturnMessage() {
		return returnMessage;
	}

	public void setReturnMessage(ReturnMessage returnMessage) {
		this.returnMessage = returnMessage;
	}

	public OrderVo getOrder() {
		return order;
	}

	public void setOrder(OrderVo order) {
		this.order = order;
	}
	
	/**
	 * 订单号查询场地
	 * 
	 * @return http://localhost:8080/OUMS/jsp/order/findOrder
	 */
	@Action(value = "findOrder", results = {
			@Result(name = "success", type = "json", params = { "root", "returnMessage" }) })
	public String findOrder() {

		returnMessage = orderService.findOrderByNumber(order);

		return "success";
	}
	
	/**
	 * 模糊查询订单，只匹配后面的  number%
	 * 
	 * @return http://localhost:8080/OUMS/jsp/order/findOrderLikeNumber
	 */
	@Action(value = "findOrderLikeNumber", results = {
			@Result(name = "success", type = "json", params = { "root", "returnMessage" }) })
	public String findOrderLikeNumber() {

		returnMessage = orderService.findOrderLikeNumber(order);

		return "success";
	}
}
