package com.oums.service;

import com.oums.bean.ReturnMessage;
import com.oums.bean.po.AdminUserPo;
import com.oums.bean.vo.AdminUserVo;
import com.oums.bean.vo.UserVo;

/**
 * admin service
 * @author Zhenghui Ou
 *
 */
public interface IAdminUserService {

	/**
	 * login service
	 * @param adminUserPo
	 * @return
	 */
	abstract ReturnMessage login(AdminUserVo adminVo);
	/**
	 * get AdminUserPo by employee number
	 * @param emplNum
	 * @return
	 */
	abstract ReturnMessage getAdminPoByEmplNum(String emplNum);
	/**
	 * register service
	 * @param adminUserPo
	 * @return
	 */
	abstract ReturnMessage regist(AdminUserVo adminVo);
	/**
	 * admin modify password of themselves
	 * @param oldPassword
	 * @param newPassword
	 * @param emplNum
	 * @return
	 */
	abstract ReturnMessage modifyPassword(String oldPassword, String newPassword, String emplNum);
	/**
	 * user admin delete user by user certificate number
	 * @param cerNum
	 * @return
	 */
	abstract ReturnMessage deleteUser(String cerNum);
	/**
	 * user admin search users by period, classes, isTourist, certificate number
	 * @param peroid
	 * @param classes
	 * @param isTourist
	 * @param cerNum
	 * @return
	 */
	abstract ReturnMessage searchUser(String period, String classes, String isTourist, String cerNum);
	/**
	 * super user search admin user by permission, employee number
	 * @param permission
	 * @param emplNum
	 * @return
	 */
	abstract ReturnMessage searchAdmin(int permission, String emplNum);
}
