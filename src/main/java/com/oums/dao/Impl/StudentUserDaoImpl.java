package com.oums.dao.Impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oums.bean.po.StudentUserPo;
import com.oums.dao.IStudentUserDao;

@Repository("studentUserDao")
public class StudentUserDaoImpl implements IStudentUserDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public StudentUserPo getStuUserByStuNum(String stuNum){
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from StudentUserPo u where u.studentNumber=:stuNum");
		query.setString("stuNum",stuNum);
		return (StudentUserPo)query.uniqueResult();
	}

}
