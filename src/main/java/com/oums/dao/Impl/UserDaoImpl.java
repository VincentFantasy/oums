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
	
	//Ҫ���û������ظ�
	@Override
	public UserPo getUserByName(String userName) {		
		return (UserPo) sessionFactory.getCurrentSession()
				.createQuery("from UserPo u where u.userName=:userName and u.isDelete = false")
				.setString("userName", userName)
				.uniqueResult();
	}

	@Override
	public void test() {
		System.out.println("testDao");
	}

}
