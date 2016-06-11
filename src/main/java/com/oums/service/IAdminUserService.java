package com.oums.service;

import com.oums.bean.ReturnMessage;
import com.oums.bean.po.AdminUserPo;
import com.oums.bean.vo.AdminUserVo;

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

}