package com.oums.dao.Impl;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oums.bean.po.BasePo;
import com.oums.dao.IBaseDao;

@Repository(value="baseDao")
public class BaseDaoImpl implements IBaseDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public <T extends BasePo> Serializable add(T po) {		
		return sessionFactory.getCurrentSession().save(po);
	}

	@Override
	public <T extends BasePo> void delete(T po) {
		sessionFactory.getCurrentSession().delete(po);
	}

	@Override
	public <T extends BasePo> T findById(Class<T> poClass, Integer id) {
		return (T) sessionFactory.getCurrentSession().get(poClass, id);
	}

	@Override
	public <T extends BasePo> void update(T po) {
		sessionFactory.getCurrentSession().update(po);
	}

}
