package com.oums.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oums.bean.ReturnMessage;
import com.oums.bean.po.EquipmentPo;
import com.oums.bean.po.EquipmentTypePo;
import com.oums.bean.po.OrderPo;
import com.oums.bean.po.SitePo;
import com.oums.bean.type.OrderType;
import com.oums.bean.vo.EquipmentTypeVo;
import com.oums.bean.vo.EquipmentVo;
import com.oums.bean.vo.OrderVo;
import com.oums.dao.IBaseDao;
import com.oums.dao.IEquipmentDao;
import com.oums.service.IEquipmentService;
import com.oums.util.BeanUtil;
/**
 * 
 * @author pzh
 * TODO 实现一般用户的器材操作的服务
 * 2016年6月7日
 */
@Service("equipmentService")
public class EquipmentServiceImpl implements IEquipmentService {

	
	@Autowired
	IEquipmentDao equipmentDao;
	@Autowired
	IBaseDao baseDao;


	@Override
	public ReturnMessage findFreeEquipment(EquipmentTypeVo equipmentType) {
		// TODO Auto-generated method stub
		ReturnMessage returnMessage = new ReturnMessage();
		try{
			List<EquipmentPo> pos = equipmentDao.findFreeEquipmentList(equipmentType);
			if(pos!=null)
			returnMessage.setFlat(true);
			returnMessage.setContent("查找成功");
			returnMessage.setObject(pos);
		} catch (Exception e) {
			e.printStackTrace();
			returnMessage.setFlat(false);
			returnMessage.setContent("查找失败");
		}
		
		return returnMessage;
	}
	@Override
	public ReturnMessage findAllEquipment() {
		// TODO 查找所有器材
		ReturnMessage returnMessage = new ReturnMessage();
		try{
			List<EquipmentPo> pos = equipmentDao.findAllEquipmentList();
			if(pos!=null)
			returnMessage.setFlat(true);
			returnMessage.setContent("查找成功");
			returnMessage.setObject(pos);
		} catch (Exception e) {
			e.printStackTrace();
			returnMessage.setFlat(false);
			returnMessage.setContent("查找失败");
		}
		
		return returnMessage;
	}
	@Override
	public ReturnMessage findEquipmentByType(String content, String type) {
				ReturnMessage returnMessage = new ReturnMessage();
				System.out.println(type+"==================serviceImpl======================================");
				try{
					List<EquipmentPo> pos = equipmentDao.findEquipmentByType(content,type);
					if(pos!=null)
					returnMessage.setFlat(true);
					returnMessage.setContent("查找成功");
					returnMessage.setObject(pos);
				} catch (Exception e) {
					e.printStackTrace();
					returnMessage.setFlat(false);
					returnMessage.setContent("查找失败");
				}
				
				return returnMessage;
	}
	@Override
	public ReturnMessage findEquipmentTypeAndNum(String content, String type) {
		// TODO Auto-generated method stub
		ReturnMessage returnMessage = new ReturnMessage();
		try{
			List<EquipmentTypePo> pos= equipmentDao.findEquipmentTypeAndNum( content, type);
			if(pos!=null)
			returnMessage.setFlat(true);
			returnMessage.setContent("查找成功");
			returnMessage.setObject(pos);
		} catch (Exception e) {
			e.printStackTrace();
			returnMessage.setFlat(false);
			returnMessage.setContent("查找失败");
		}
		
		return returnMessage;
	}
	@Override
	public ReturnMessage addOrder(OrderVo vo) {
		// TODO Auto-generated method stub
		
		ReturnMessage returnMessage = new ReturnMessage();
		try{
			OrderPo po=new OrderPo();
			BeanUtil.voToPo(vo, po);
			baseDao.add(po);
			returnMessage.setFlat(true);
			returnMessage.setContent("添加订单成功");
		} catch (Exception e) {
			e.printStackTrace();
			returnMessage.setFlat(false);
			returnMessage.setContent("添加订单失败");
		}
		return returnMessage;
	}
	@Override
	public ReturnMessage findOrder(String content, String type) {
		// TODO Auto-generated method stub
		ReturnMessage returnMessage = new ReturnMessage();
		try{
			
			List<OrderPo> list=equipmentDao.findOrder(content,type);
			returnMessage.setFlat(true);
			returnMessage.setObject(list);
		} catch (Exception e) {
			e.printStackTrace();
			returnMessage.setFlat(false);
		}
		return returnMessage;
	}
	@Override
	public ReturnMessage payOrder(int id) {
		// TODO Auto-generated method stub
		ReturnMessage returnMessage = new ReturnMessage();
		try{
			
			OrderPo po=baseDao.findById(OrderPo.class, id);
			po.setOrderType(OrderType.WAITSURE);
			baseDao.update(po);
			List<OrderPo> list=equipmentDao.findOrder(null,null);
			returnMessage.setFlat(true);
			returnMessage.setObject(list);
			
		} catch (Exception e) {
			e.printStackTrace();
			returnMessage.setFlat(false);
		}
		return returnMessage;
	}
	@Override
	public ReturnMessage delOrder(int id) {
		// TODO Auto-generated method stub
		ReturnMessage returnMessage = new ReturnMessage();
		try{
			
			OrderPo po=baseDao.findById(OrderPo.class, id);
			po.setIsDelete(true);
			baseDao.update(po);
			List<OrderPo> list=equipmentDao.findOrder(null,null);
			returnMessage.setFlat(true);
			returnMessage.setObject(list);
			
		} catch (Exception e) {
			e.printStackTrace();
			returnMessage.setFlat(false);
		}
		return returnMessage;
	}
	

}
