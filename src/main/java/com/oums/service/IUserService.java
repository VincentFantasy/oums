package com.oums.service;

import com.oums.bean.ReturnMessage;
import com.oums.bean.vo.UserVo;


/**
 * user service
 * @author Zhenghui Ou
 *  
 */
public interface IUserService {
	/**
	 * login service
	 * @param UserVo
	 * @return
	 */
	abstract ReturnMessage login(UserVo UserVo);
	/**
	 * get userPo by certificate number
	 * @param cerNum
	 * @return
	 */
	abstract ReturnMessage getUserPoByCerNum(String cerNum);

	/**
	 * register service
	 * @param userVo
	 * @return
	 */
	abstract ReturnMessage regist(UserVo userVo);
	/**
	 * users modify password of themselves
	 * @param uservo
	 * @return
	 */
	abstract ReturnMessage modifyPassword(String oldPassword, String newPassword, String cerNum);

}
