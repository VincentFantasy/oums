package com.oums.dao.Impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oums.bean.po.UserPo;
import com.oums.dao.IUserDao;

@Repository("userDao")
public class UserDaoImpl implements IUserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	//要求用户名不重复
	@Override
	public UserPo getUserByName(String userName) {		
		return (UserPo) sessionFactory.getCurrentSession()
				.createQuery("from UserPo u where u.userName=:userName")
				.setString("userName", userName)
				.uniqueResult();
	}

	@Override
	public void test() {
		System.out.println("testDao");
	}

}
