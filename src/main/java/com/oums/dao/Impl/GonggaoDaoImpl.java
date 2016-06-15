package com.oums.dao.Impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oums.bean.po.GonggaoPo;
import com.oums.dao.IGonggaoDao;

@Repository(value="gonggaoDao")
public class GonggaoDaoImpl implements IGonggaoDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<GonggaoPo> findGonggaoLikeName(String name) {
		return sessionFactory.getCurrentSession()
				.createQuery("from GonggaoPo g where g.gonggaoTitile like '%" + name + "%' and g.isDelete = false")
				.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GonggaoPo> getAllGonggao() {
		return sessionFactory.getCurrentSession()
				.createQuery("from GonggaoPo g where g.isDelete = false")
				.list();
	}

}
