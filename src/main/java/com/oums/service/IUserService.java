package com.oums.service;

import com.oums.bean.ReturnMessage;
import com.oums.bean.vo.UserVo;

/**
 * 用户服务
 * @author 谭治
 *
 */
public interface IUserService {
	
	/**
	 * 添加用户（未完善）
	 * @return
	 */
	ReturnMessage addUser(UserVo userVo);
	
	/**
	 * 根据用户名查找用户（未完成）
	 * @param userName
	 * @return
	 */
	ReturnMessage findUserByUserName(String userName);
	
}
