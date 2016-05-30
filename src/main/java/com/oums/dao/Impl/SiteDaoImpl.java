package com.oums.dao.Impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oums.bean.po.SitePo;
import com.oums.dao.ISiteDao;

@Repository(value="siteDao")
public class SiteDaoImpl implements ISiteDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public SitePo findSitePoBySiteName(String siteName) {
		return (SitePo) sessionFactory.getCurrentSession()
				.createQuery("from SitePo s where s.siteName = :siteName and s.isDelete = false")
				.setString("siteName", siteName)
				.uniqueResult();
	}

	@Override
	public List<SitePo> findSitePoBySiteType(Integer type) {
		// TODO Auto-generated method stub
		return null;
	}

}
