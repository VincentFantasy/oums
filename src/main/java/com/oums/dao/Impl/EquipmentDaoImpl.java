package com.oums.dao.Impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oums.bean.po.EquipmentPo;
import com.oums.bean.po.EquipmentTypePo;
import com.oums.bean.po.OrderPo;
import com.oums.bean.vo.EquipmentTypeVo;
import com.oums.bean.vo.EquipmentVo;
import com.oums.dao.IEquipmentDao;

@Repository(value="equipmentDao")
public class EquipmentDaoImpl implements IEquipmentDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public EquipmentTypePo findEquipmentByName(String equipName) {
		// TODO Auto-generated method stub
		return (EquipmentTypePo) sessionFactory.getCurrentSession()
				.createQuery("from EquipmentTypePo e where e.isDelete = 1 and  e.equipName = :Name  ")
				.setString("equipName", equipName)
				.uniqueResult();
		
	}


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
				.createQuery("from EquipmentPo e where e.isDelete = 1").list();
		return list;

	}

	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EquipmentPo> findEquipmentByType(String content, String type) {
		String hql="from EquipmentPo e where  e.isDelete = 1 ";
		if(content!=null&&!("".equals(content))){
			if(type.equals("equipName")){
				hql=hql+" and e.equipName = '" +content+"'";
			}
			else if(type.equals("equipBrand")){
				hql=hql+" and e.equipBrand = '" +content+"'";
			}
		}
//		hql=hql+" and e.isDelete = 1";
		List<EquipmentPo> list=sessionFactory.getCurrentSession()
				.createQuery(hql).list();
		
		return list;
	}



	@SuppressWarnings("unchecked")
	@Override
	public List<EquipmentTypePo> findEquipmentTypeAndNum(String content, String type) {
		// TODO Auto-generated method stub
		String hql="from EquipmentTypePo e where 1 = 1 ";
		if(content!=null&&!("".equals(content))){
			if(type.equals("equipName")){
				hql=hql+" and e.equipName = '" +content+"'";
			}
			else if(type.equals("equipBrand")){
				hql=hql+" and e.equipBrand = '" +content+"'";
			}
		}
//		hql=hql+" and e.isDelete = 1";
		List<EquipmentTypePo> list=sessionFactory.getCurrentSession()
				.createQuery(hql).list();
		
	
		return list;
	
	}



	@SuppressWarnings("unchecked")
	@Override
	public List<OrderPo> findOrder(String content, String type) {
		int ox=Integer.parseInt("0x01".substring(2), 16);
		String hql="from OrderPo e where e.isDelete = 1 and e.orderType= '"+ ox +"'";
		if(content!=null&&!("".equals(content))){
			if(type.equals("equipName")){
				hql=hql+" and e.equipName = '" +content+"'";
			}
			else if(type.equals("equipBrand")){
				hql=hql+" and e.equipBrand = '" +content+"'";
			}
		}
		// TODO Auto-generated method stub
		List<OrderPo> list= sessionFactory.getCurrentSession()
				.createQuery(hql).list();
		return list;
	}



	@SuppressWarnings("unchecked")
	@Override
	public List<OrderPo> findWaitSureOrder() {
		// TODO Auto-generated method stub
		int ox=Integer.parseInt("0x02".substring(2), 16);
		List<OrderPo> list= sessionFactory.getCurrentSession()
		.createQuery("from OrderPo e where e.isDelete = 1 and e.orderType=  '"+ox+"' ").list();
		return list;
	}


	@SuppressWarnings("unchecked")
	@Override
	public int findEquipTypeIdByName(EquipmentVo vo) {
		// TODO Auto-generated method stub
		List<EquipmentTypePo> po=(List<EquipmentTypePo>) sessionFactory.getCurrentSession()
		.createQuery("from EquipmentTypePo e where e.equipBrand = :equipBrand and  e.equipName = :equipName  ")
		.setString("equipName", vo.getEquipName()).setString("equipBrand", vo.getEquipBrand()).list();
		
		return po.get(0).getEquipTypeId();
	}



	

}
