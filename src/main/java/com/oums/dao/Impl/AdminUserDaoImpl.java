package com.oums.dao.Impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oums.bean.po.AdminUserPo;
import com.oums.bean.po.UserPo;
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

	@Override
	public void deleteUser(UserPo userPo) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tran = session.beginTransaction();
		session.update(userPo);
		tran.commit();
	}

	@Override
	public List<UserPo> searchUser(String period, String classes, String isTourist, String cerNum) {
		Session session = sessionFactory .getCurrentSession();
		System.out.println(period);
		System.out.println(classes);
		System.out.println(isTourist);
		System.out.println(cerNum);
		
		Criteria cri = session.createCriteria(UserPo.class);
		if(!period.equals("*")){
			Criterion cron = Restrictions.like("period","%"+period+"%");
			cri.add(cron);
		}
		if(!classes.equals("*")){
			Criterion cron = Restrictions.like("classes","%"+classes+"%");
			cri.add(cron);
		}
		if(!isTourist.equals("*")){
			if(isTourist.equals("true")){
				Criterion cron = Restrictions.eq("isTourist",true);
				cri.add(cron);
			}
			if(isTourist.equals("false")){
				Criterion cron = Restrictions.eq("isTourist",false);
				cri.add(cron);
			}
		}
		if(!cerNum.equals("*")){
			Criterion cron = Restrictions.like("certificateNumber","%"+cerNum+"%");
			cri.add(cron);
		}
		List<UserPo> userList = cri.list();
		System.out.println(userList.toString());
		return userList;
	}

}
