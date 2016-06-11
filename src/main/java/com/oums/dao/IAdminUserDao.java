package com.oums.dao;

import com.oums.bean.po.AdminUserPo;



/**
 * 
 * @author Zhenghui Ou
 *
 */
public interface IAdminUserDao {
	/**
	 * get admin po by employee number
	 * @param emplNum
	 * @return
	 */
	abstract AdminUserPo getAdminByEmplNum(String emplNum);	
	/**
	 * admin register service
	 * @param adminPo
	 */
	abstract void userRegist(AdminUserPo adminPo);
	/**
	 * admin modify the password of themselves
	 * @param adminPo
	 */
	abstract void modifyPassword(AdminUserPo adminPo);
}
