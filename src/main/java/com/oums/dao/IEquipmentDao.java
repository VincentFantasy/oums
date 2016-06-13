package com.oums.dao;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.oums.bean.po.EquipmentPo;
import com.oums.bean.po.EquipmentTypePo;
import com.oums.bean.vo.EquipmentTypeVo;
import com.oums.bean.vo.EquipmentVo;

public interface IEquipmentDao {



	
	/**
	 * 根据器材名查找器材种类
	 * @param string
	 * @return equipmentTypePo
	 */
	EquipmentTypePo findEquipmentByName(String string);



	
	/**
	 * 
	 * 查找一定数量空闲的器材
	 * @param equipmentType
	 * @return List<EquipmentPo>
	 */
	List<EquipmentPo> findFreeEquipmentList(EquipmentTypeVo equipmentType);
	
	/**
	 * 查找器材,返回器材列表
	 * @param equipmentType
	 * @return List<EquipmentPo>
	 */
	List<EquipmentPo> findAllEquipmentList();

	/**
	 * 查找器材,返回符合条件的器材列表
	 * @param equipmentType
	 * @return List<EquipmentTypePo>
	 */
	List<EquipmentPo> findEquipmentByType(String content, String type);

	/**
	 * 查找器材,返回器材种类及数量
	 * @param equipmen
	 * @return Map
	 */
	List<EquipmentPo> findEquipmentTypeAndNum();
	
}
