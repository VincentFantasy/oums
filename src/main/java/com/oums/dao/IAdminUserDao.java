package com.oums.dao;

import java.util.List;

import com.oums.bean.po.AdminUserPo;
import com.oums.bean.po.UserPo;



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
	/**
	 * admin delete user
	 * @param userPo
	 */
	abstract void deleteUser(UserPo userPo);
	/**
	 * search users by period, classes, isTourist, certificate number
	 * @param period
	 * @param classes
	 * @param isTourist
	 * @param cerNum
	 * @return
	 */
	abstract List<UserPo> searchUser(String period, String classes, String isTourist, String cerNum);
	/**
	 * search admin user by permission, employee number
	 * @param permission
	 * @param emplNum
	 * @return
	 */
	abstract List<AdminUserPo> searchAdmin(int permission, String emplNum);
}
