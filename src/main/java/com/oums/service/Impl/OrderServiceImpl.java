package com.oums.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oums.bean.ReturnMessage;
import com.oums.bean.po.OrderPo;
import com.oums.bean.vo.OrderVo;
import com.oums.dao.IOrderDao;
import com.oums.service.IOrderService;

@Service("orderService")
public class OrderServiceImpl implements IOrderService {

	@Autowired
	IOrderDao orderDao;
	
	@Override
	public ReturnMessage findOrderByNumber(OrderVo vo) {
		ReturnMessage returnMessage = new ReturnMessage();
		
		try{
			OrderPo po = orderDao.findOrderByNumber(vo.getOrderNumber());
			
			//如果找到的为空
			if(po == null)
				throw new NullPointerException();
			
			returnMessage.setObject(po);
			returnMessage.setFlat(true);
			returnMessage.setContent("操作成功");
		} catch(NullPointerException e){
			returnMessage.setFlat(false);
			returnMessage.setContent("找不到此订单");
		} catch(Exception e) {
			e.printStackTrace();
			returnMessage.setFlat(false);
			returnMessage.setContent("操作异常");
		}
		
		return returnMessage;
	}

}
