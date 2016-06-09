package com.oums.service;

import com.oums.bean.ReturnMessage;
import com.oums.bean.vo.UserVo;


/**
 * 
 * @author Ou
 * service for studentUser login, 
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
	 * regist service
	 * @param userVo
	 * @return
	 */
	abstract ReturnMessage regist(UserVo userVo);
}
