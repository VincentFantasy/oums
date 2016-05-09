package com.oums.service;

import com.oums.bean.ReturnMessage;
import com.oums.bean.vo.UserVo;

public interface IUserService {

	/**
	 * 测试
	 * @return
	 */
	ReturnMessage test();
	
	/**
	 * 注册
	 * @return
	 */
	ReturnMessage addUser(UserVo userVo);
	
	/**
	 * 根据用户名查找用户
	 * @param userName
	 * @return
	 */
	ReturnMessage findUserByUserName(String userName);
	
}
