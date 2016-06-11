package com.oums.dao;

import com.oums.bean.po.UserPo;
/**
 * 
 * @author Zhenghui Ou
 *
 */
public interface IUserDao {
	/**
	 * get user by certificate number
	 * @param stuNum
	 * @return
	 */
	abstract UserPo getUserByCerNum(String stuNum);	
	/**
	 * user register
	 * @param userPo
	 */
	abstract void userRegist(UserPo userPo);
	/**
	 * user modifies the password of themselves
	 * @param newPassword
	 */
	abstract void modifyPassword(UserPo userPo);
}

