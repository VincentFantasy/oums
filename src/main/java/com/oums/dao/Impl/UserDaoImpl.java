package com.oums.dao.Impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.oums.bean.po.UserPo;
import com.oums.dao.IUserDao;

@Repository("userDao")
public class UserDaoImpl implements IUserDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public UserPo getUserByCerNum(String cerNum){
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from UserPo u where u.certificateNumber=:cerNum");
		query.setString("cerNum",cerNum);
		return (UserPo)query.uniqueResult();
	}

}
