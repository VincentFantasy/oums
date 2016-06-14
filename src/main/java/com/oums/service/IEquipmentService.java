package com.oums.service;

import com.oums.bean.ReturnMessage;
import com.oums.bean.vo.EquipmentTypeVo;
import com.oums.bean.vo.EquipmentVo;
import com.oums.bean.vo.OrderVo;

/**
 * 
 * @author pzh
 * TODO 一般用户的器材操作服务
 * 2016年6月7日
 */
public interface IEquipmentService {

//	/**
//	 * 查找器材,根据器材名称,或器材品牌
//	 * @param equipmentType
//	 * @return ReturnMessage
//	 */
//	ReturnMessage findEquipment(EquipmentVo equipment);
	
	
	/**
	 * 器材租借 从页面接EquipmentType 根据数量,然后选择空闲状态的器材项设为租借.
	 * @param equipmentType
	 * @return ReturnMessage
	 */
	ReturnMessage findFreeEquipment(EquipmentTypeVo equipmentType);

	/**
	 * 查找器材,
	 * @param 
	 * @return ReturnMessage
	 */
	ReturnMessage findAllEquipment();

	/**
	 * 查找器材,根据器材名称,或器材品牌
	 * @param content
	 * @param type
	 * @return
	 */
	ReturnMessage findEquipmentByType(String content, String type);
	
	
	/**
	 * 查找器材种类及数量
	 * @return
	 */
	ReturnMessage findEquipmentTypeAndNum();
	
	/**
	 * 添加器材订单
	 * @param order
	 * @return
	 */
	ReturnMessage addOrder(OrderVo order);
	
	/**
	 * 查找所有非删除状态的订单
	 * @return
	 */
	ReturnMessage findOrder();
	
	/**
	 * 订单支付
	 * @param id
	 * @return
	 */
	ReturnMessage payOrder(int id);
	
	/**
	 * 订单删除
	 * @param id
	 * @return
	 */
	ReturnMessage delOrder(int id);



}
