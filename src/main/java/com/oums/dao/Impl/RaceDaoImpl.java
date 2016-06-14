package com.oums.dao.Impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oums.bean.po.RacePo;
import com.oums.dao.IRaceDao;

@Repository(value="raceDao")
public class RaceDaoImpl implements IRaceDao {	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public RacePo findRackByName(String name) {
		return (RacePo) sessionFactory.getCurrentSession()
				.createQuery("from RacePo r where r.raceName = :name and r.isDelete = false")
				.setString("name", name)
				.uniqueResult();
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<RacePo> findRaceLikeName(String name) {
		return sessionFactory.getCurrentSession()
				.createQuery("from RacePo r where r.raceName like '%" + name + "%' and r.isDelete = false")
//				.setString("name", name) 
				.list();
	}

}
