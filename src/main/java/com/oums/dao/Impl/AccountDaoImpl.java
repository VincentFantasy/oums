package com.oums.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oums.bean.po.AccountPo;
import com.oums.bean.vo.PaginationVo;
import com.oums.dao.IAccountDao;
import com.oums.dao.IBaseDao;
import com.oums.util.Pagination;



@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {
	 
	
	@Autowired
	IBaseDao baseDao;
	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * 分页获取账户流水
	 * @author 友新
	 * @return Pagination  
	 * 				分页校准、封装类
	 */
	public Pagination getAccountFlows(PaginationVo paginationVo) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from AccountPo where isDelete=false ";
		Query query = session.createQuery(hql);
		String totalHql = "select count(*) " + hql; 
		//查询记录总数
		Long count = (Long) sessionFactory.getCurrentSession().createQuery(totalHql).uniqueResult();
		//校正分页码
		Pagination pagination = new Pagination(paginationVo.getPageNo(), paginationVo.getPageSize(), count.intValue());
	
		List<AccountPo> list = new ArrayList<AccountPo>();
		try {
			//获得查询结果
			list =sessionFactory.getCurrentSession().createQuery(hql)
				.setMaxResults(pagination.getPageSize())
				.setFirstResult(pagination.getFirstResult())
				.list();
			pagination.setList(list);
		} catch (HibernateException e) {
		}
		return pagination;
	}


}
