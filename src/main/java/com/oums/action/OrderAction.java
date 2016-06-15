package com.oums.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.oums.bean.Page;
import com.oums.bean.ReturnMessage;
import com.oums.bean.po.OrderPo;
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

	private Page page;
	
	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
	
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
		
		@SuppressWarnings("unchecked")
		List<OrderPo> list = (List<OrderPo>) returnMessage.getObject();
		page.setRecordCount(list.size());
		list = page.thisPageData(list);
		returnMessage.setObject(list);
		returnMessage.setPageCount(page.getPageCount());
		
		return "success";
	}
}
