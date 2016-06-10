package com.oums.dao;

import com.oums.bean.po.UserPo;
/**
 * 
 * @author Zhenghui Ou
 *
 */
public interface IUserDao {
	abstract UserPo getUserByCerNum(String stuNum);	
	
	abstract void userRegist(UserPo userPo);
}

