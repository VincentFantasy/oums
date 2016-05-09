package com.oums.dao;

import com.oums.bean.po.UserPo;

/**
 * 
 * @author fantasy
 *
 */
public interface IUserDao {

	/**
	 * 根据用户名查找用户
	 * @param user
	 * @return
	 */
	abstract UserPo getUserByName(String userName);
	
	/**
	 * 
	 */
	void test();
	
}
