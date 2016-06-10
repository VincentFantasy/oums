package com.oums.dao;

import com.oums.bean.po.AdminUserPo;


/**
 * 
 * @author Zhenghui Ou
 *
 */
public interface IAdminUserDao {
	abstract AdminUserPo getAdminByEmplNum(String emplNum);	
	
	abstract void userRegist(AdminUserPo adminPo);
}
