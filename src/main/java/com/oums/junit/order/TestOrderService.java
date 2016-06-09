package com.oums.junit.order;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.oums.bean.ReturnMessage;
import com.oums.bean.po.OrderPo;
import com.oums.bean.vo.OrderVo;
import com.oums.junit.BaseUnit;
import com.oums.service.IOrderService;

/**
 * 
 * @author 谭治
 *
 */
public class TestOrderService extends BaseUnit {

	@Autowired
	IOrderService orderService;
	
	@Test
	public void testFindOrderByNumber() {
		OrderVo vo = new OrderVo();
		vo.setOrderNumber("201606072215251059");
		ReturnMessage returnMessage = orderService.findOrderByNumber(vo);
		
		//存在的订单
		if(returnMessage.isFlat()) {
			OrderPo po = (OrderPo) returnMessage.getObject();
			System.out.println(po);
			assertTrue(true);
		} else {
			fail();
		}
		
		//不存在的订单
		vo.setOrderNumber("123");
		returnMessage = orderService.findOrderByNumber(vo);
		assertTrue(!returnMessage.isFlat());
	}
	
}
