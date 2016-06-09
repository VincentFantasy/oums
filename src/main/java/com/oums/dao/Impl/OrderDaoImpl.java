package com.oums.dao.Impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oums.bean.po.OrderPo;
import com.oums.dao.IOrderDao;

@Repository(value="orderDao")
public class OrderDaoImpl implements IOrderDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<OrderPo> findOrderByClass(int orderClass) {
		return sessionFactory.getCurrentSession()
				.createQuery("from OrderPo o where o.orderClass = :orderClass and o.isDelete = false")
				.setInteger("orderClass", orderClass)
				.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderPo> findOrderByUserAndClass(int userId, int orderClass) {
		return sessionFactory.getCurrentSession()
				.createQuery("from OrderPo o where o.user = :userId and o.orderClass = :orderClass and o.isDelete = false")
				.setInteger("userId", userId)
				.setInteger("orderClass", orderClass)
				.list();
	}

	
	@Override
	public OrderPo findOrderByNumber(String orderNumber) {
		return (OrderPo) sessionFactory.getCurrentSession()
				.createQuery("from OrderPo o where o.orderNumber = :orderNumber and o.isDelete = false")
				.setString("orderNumber", orderNumber)
				.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderPo> findOrderByType(int orderType) {
		return sessionFactory.getCurrentSession()
				.createQuery("from OrderPo o where o.orderType = :orderType and o.isDelete = false")
				.setInteger("orderType", orderType)
				.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderPo> findOrderByTypeAndClass(int orderType, int orderClass) {
		return sessionFactory.getCurrentSession()
				.createQuery("from OrderPo o where o.orderType = :orderType and o.orderClass = :orderClass and o.isDelete = false")
				.setInteger("orderType", orderType)
				.setInteger("orderClass", orderClass)
				.list();
	}

}
