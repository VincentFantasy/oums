package com.oums.dao.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.oums.bean.po.EquipmentPo;
import com.oums.bean.po.EquipmentTypePo;
import com.oums.bean.po.OrderPo;
import com.oums.bean.po.SitePo;
import com.oums.bean.vo.EquipmentTypeVo;
import com.oums.bean.vo.EquipmentVo;
import com.oums.dao.IEquipmentDao;

public class EquipmentDaoImpl implements IEquipmentDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public EquipmentTypePo findEquipmentByName(String equipName) {
		// TODO Auto-generated method stub
		return (EquipmentTypePo) sessionFactory.getCurrentSession()
				.createQuery("from EquipmentTypePo e where e.equipName = :Name  ")
				.setString("equipName", equipName)
				.uniqueResult();
		
	}



//	@SuppressWarnings("rawtypes")
//	@Override
//	public HashMap findEquipmentList(EquipmentVo equipment) {
//		String hql="from EquipmentPo e where 1=1 ";
//		if(equipment.getEquipName()!=null){
//			hql=hql+"e.equipName = " +equipment.getEquipName();
//		}
//		if(equipment.getEquipName()!=null){
//			hql=hql+"e.equipBrand = " +equipment.getEquipBrand();
//		}
//		
//		@SuppressWarnings("unchecked")
//		List<EquipmentPo> listType=sessionFactory.getCurrentSession()
//				.createQuery(hql).list();
//		
//		@SuppressWarnings("unchecked")
//		List<EquipmentPo> listItem= sessionFactory.getCurrentSession()
//		.createQuery("from EquipmentPo e where e.equipName = :Name and e.equipBrand = :equipBrand ")
//		.setString("equipName", equipment.getEquipName())
//		.list();
//		
//		HashMap<String, List> list=new HashMap<String,List>();
//		list.put("listType", listType);
//		list.put("listItem", listItem);
//		return list;
//	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EquipmentPo> findFreeEquipmentList(EquipmentTypeVo equipmentType) {
		// TODO Auto-generated method stub
		List<EquipmentPo> listItem= sessionFactory.getCurrentSession()
		.createQuery("from EquipmentPo e where e.itemState=222"
				+ " e.equipName = :Name and"
				+ " e.equipBrand = :equipBrand ")
		.setString("equipName", equipmentType.getEquipName())
		.setString("equipBrand", equipmentType.getEquipBrand())
		.setFirstResult(0).setMaxResults(equipmentType.getEquipNum())
		.list();
		return listItem;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<EquipmentPo> findAllEquipmentList() {
		// TODO Auto-generated method stub
		List<EquipmentPo> list= sessionFactory.getCurrentSession()
				.createQuery("from EquipmentPo e where isDelete = false").list();
		return list;

	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<EquipmentPo> findEquipmentByType(String content, String type) {
		// TODO Auto-generated method stub
		String hql="from EquipmentPo e where 1=1 ";
		if(type=="equipName"){
			hql=hql+"e.equipName = " +content;
		}
		if(type=="equipBrand"){
			hql=hql+"e.equipBrand = " +content;
		}
		List<EquipmentPo> list=sessionFactory.getCurrentSession()
				.createQuery(hql).list();
		return list;
	}



	@SuppressWarnings("unchecked")
	@Override
	public List<EquipmentPo> findEquipmentTypeAndNum() {
		// TODO Auto-generated method stub
		String hql="select equipName ,equipBrand,equipPrice,rentPrice,"
				+ "count(equipBrand) as equipNum from EquipmentPo e where"
				+ " e.isDelete=false group by e.equipBrand ";
		List<EquipmentPo> list= sessionFactory.getCurrentSession()
				.createQuery(hql).list();
		
	
		return list;
	
	}



	@SuppressWarnings("unchecked")
	@Override
	public List<OrderPo> findOrder() {
		// TODO Auto-generated method stub
		List<OrderPo> list= sessionFactory.getCurrentSession()
				.createQuery("from OrderPo e where e.isDelete = false and e.orderType= 0x01 ").list();
		return list;
	}



	@SuppressWarnings("unchecked")
	@Override
	public List<OrderPo> findWaitSureOrder() {
		// TODO Auto-generated method stub
		List<OrderPo> list= sessionFactory.getCurrentSession()
		.createQuery("from OrderPo e where e.isDelete = false and e.orderType=  0x02 ").list();
		return list;
	}



	

}
