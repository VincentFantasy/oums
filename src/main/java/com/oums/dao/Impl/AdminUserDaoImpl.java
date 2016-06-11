package com.oums.dao.Impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oums.bean.po.AdminUserPo;
import com.oums.dao.IAdminUserDao;


@Repository("adminUserDao")
public class AdminUserDaoImpl implements IAdminUserDao {

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public AdminUserPo getAdminByEmplNum(String emplNum) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from AdminUserPo u where u.employeeNumber=:emplNum");
		query.setString("emplNum",emplNum);
		return (AdminUserPo)query.uniqueResult();
	}

	@Override
	public void userRegist(AdminUserPo adminPo) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tran = session.beginTransaction();
		session.save(adminPo);
		tran.commit();
		
	}

	@Override
	public void modifyPassword(AdminUserPo adminPo) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tran = session.beginTransaction();
		session.update(adminPo);
		tran.commit();
	}

}
