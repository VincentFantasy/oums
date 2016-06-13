package com.oums.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.oums.bean.ReturnMessage;
import com.oums.bean.po.EquipmentPo;
import com.oums.bean.po.EquipmentTypePo;
import com.oums.bean.po.SitePo;
import com.oums.bean.vo.EquipmentTypeVo;
import com.oums.bean.vo.EquipmentVo;
import com.oums.dao.IEquipmentDao;
import com.oums.service.IEquipmentService;
/**
 * 
 * @author pzh
 * TODO 实现一般用户的器材操作的服务
 * 2016年6月7日
 */
public class EquipmentServiceImpl implements IEquipmentService {

	
	@Autowired
	IEquipmentDao equipmentDao;

//	public ReturnMessage findEquipment(EquipmentVo equipment) {
//		
//		ReturnMessage returnMessage = new ReturnMessage();
//		try{
//			HashMap pos = equipmentDao.findEquipmentList(equipment);
//			returnMessage.setFlat(true);
//			returnMessage.setContent("查找成功");
//			returnMessage.setObject(pos);
//		} catch (Exception e) {
//			e.printStackTrace();
//			returnMessage.setFlat(false);
//			returnMessage.setContent("查找失败");
//		}
//		
//		return returnMessage;
//	}
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
		// TODO 查找所有器材
				ReturnMessage returnMessage = new ReturnMessage();
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
	public ReturnMessage findEquipmentTypeAndNum() {
		// TODO Auto-generated method stub
		ReturnMessage returnMessage = new ReturnMessage();
		try{
			List<EquipmentPo> pos= equipmentDao.findEquipmentTypeAndNum();
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
	

}
