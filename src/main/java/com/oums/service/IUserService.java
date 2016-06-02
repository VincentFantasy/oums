package com.oums.service;

import com.oums.bean.ReturnMessage;
import com.oums.bean.vo.UserVo;


/**
 * 
 * @author Ou
 * service for studentUser login, 
 */
public interface IUserService {
	public ReturnMessage login(UserVo UserVo);
	

}
