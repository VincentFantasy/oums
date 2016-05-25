package com.oums.dao;

import com.oums.bean.po.UserPo;

/**
 * 
 * @author fantasy
 *
 */
public interface IUserDao {

	/**
	 * 根据姓名获得UserPo
	 * @param user
	 * @return
	 */
	abstract UserPo getUserByName(String userName);
	
}
