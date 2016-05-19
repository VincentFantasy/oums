package com.oums.service;

import com.oums.bean.ReturnMessage;
import com.oums.bean.vo.UserVo;

/**
 * 
 * @author 谭治
 *
 */
public interface IUserService {

	/**
	 * 测试方法
	 * @return
	 */
	ReturnMessage test();
	
	/**
	 * 添加用户
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
