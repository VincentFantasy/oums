package com.oums.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.oums.bean.ReturnMessage;
import com.oums.bean.po.EquipmentPo;
import com.oums.bean.po.EquipmentTypePo;
import com.oums.bean.type.ItemState;
import com.oums.bean.vo.EquipmentVo;
import com.oums.dao.IBaseDao;
import com.oums.dao.IEquipmentDao;
import com.oums.service.IEquipmentManagerService;
import com.oums.util.BeanUtil;
import com.oums.util.TimeUtil;


/**
 * 
 * @author pzh
 * TODO 实现管理员的器材操作的服务
 * 2016年6月7日
 */
public class EquipmentManagerServiceImpl implements IEquipmentManagerService {
	
	@Autowired
	IEquipmentDao equipmentDao;
	@Autowired
	IBaseDao baseDao;

	
	@Override
	public ReturnMessage addEquipment(EquipmentVo vo) {
		// TODO
		ReturnMessage returnMessage = new ReturnMessage();
		try{
			EquipmentPo po = new EquipmentPo();
			po.setEquipName(vo.getEquipName());
			po.setEquipBrand(vo.getEquipBrand());
			po.setEquipPrice(vo.getEquipPrice());
			po.setEquipDtail(vo.getEquipDtail());
			po.setAddTime(TimeUtil.getNowTime());
			po.setRentPrice(vo.getRentPrice());
			po.setIsDelete(false);
			po.setItemState(ItemState.FREE);
			int i=vo.getEquipNum();
	
			for(int j=0;j<i;j++){
				baseDao.add(po);
			}
			returnMessage.setFlat(true);
			returnMessage.setContent("添加成功");
		}catch(Exception e){
			e.printStackTrace();
			returnMessage.setFlat(false);
			returnMessage.setContent("添加失败" + e);
		}
		return returnMessage;
	}

	

	@Override
	public ReturnMessage delEquipment(int id) {
		// TODO Auto-generated method stub
		ReturnMessage returnMessage=new ReturnMessage();
		try{
			EquipmentPo po= baseDao.findById(EquipmentPo.class, id);
			po.setIsDelete(true);
			baseDao.update(po);
			returnMessage.setFlat(true);
			returnMessage.setContent("删除成功!" );
		}catch(Exception e){
			e.printStackTrace();
			returnMessage.setFlat(false);
			returnMessage.setContent("删除失败" + e);
		}
		return returnMessage;

	}

	@Override
	public ReturnMessage updateEquipment(EquipmentVo equipment) {
		// TODO Auto-generated method stub\
		ReturnMessage returnMessage=new ReturnMessage();
		int id=Integer.parseInt(equipment.getEquipId());
		try{
			EquipmentPo etp= baseDao.findById(EquipmentPo.class, id);
			etp.setEquipName(equipment.getEquipName());
			etp.setEquipBrand(equipment.getEquipBrand());
			etp.setEquipDtail(equipment.getEquipDtail());
			etp.setEquipPrice(equipment.getEquipPrice());
			etp.setRentPrice(equipment.getEquipPrice());
			baseDao.update(etp);
			returnMessage.setFlat(true);
			returnMessage.setContent("更新成功!");
		}catch(Exception e){
			e.printStackTrace();
			returnMessage.setFlat(false);
			returnMessage.setContent("更新失败" + e);
		}
		return returnMessage;
	}




	@Override
	public ReturnMessage findEquipmentById(int id) {
		// TODO Auto-generated method stub
		ReturnMessage returnMessage=new ReturnMessage();
		try{
			EquipmentPo po= baseDao.findById(EquipmentPo.class, id);
			returnMessage.setObject(po);
			returnMessage.setFlat(true);
			returnMessage.setContent("删除成功!" );
		}catch(Exception e){
			e.printStackTrace();
			returnMessage.setFlat(false);
			returnMessage.setContent("删除失败" + e);
		}
		return returnMessage;
	}



	@Override
	public void updateEquipment(EquipmentPo equipmentPo) {
		baseDao.update(equipmentPo);
		
	}
}
