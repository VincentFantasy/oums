package com.oums.service;

import com.oums.bean.ReturnMessage;
import com.oums.bean.po.EquipmentPo;
import com.oums.bean.vo.EquipmentVo;

/**
 * 
 * @author pzh
 * TODO 管理员的器材操作服务
 * 2016年6月7日
 */
public interface IEquipmentManagerService {
	
	/**
	 * 添加器材
	 * @param equipmentType
	 * @return ReturnMessage
	 */
	ReturnMessage addEquipment(EquipmentVo equipment);
	
	

	/**
	 * 删除器材
	 * @param id 
	 * @return ReturnMessage
	 */
	ReturnMessage delEquipment(int id);

	/**
	 * 更新器材信息
	 * @param equipmentType
	 * @return ReturnMessage
	 */
	ReturnMessage updateEquipment(EquipmentVo equipment);


	/**
	 * 查找器材
	 * @param id
	 * @return
	 */
	ReturnMessage findEquipmentById(int id);


	/**
	 * 更新器材
	 * @param equipmentPo
	 */
	void updateEquipment(EquipmentPo equipmentPo);






	

	

}
