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

	@SuppressWarnings("unchecked")
	@Override
	public List<SitePo> findSitePoBySiteType(int type) {
		List<SitePo> list = sessionFactory.getCurrentSession()
				.createQuery("from SitePo s where s.siteType = :siteType and s.isDelete = false")
				.setInteger("siteType", type)
				.list();
		return list;
	}

}
