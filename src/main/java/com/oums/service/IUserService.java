package com.oums.service;

import com.oums.bean.ReturnMessage;
import com.oums.bean.vo.UserVo;


/**
 * 
 * @author Ou
 * service for studentUser login, 
 */
public interface IUserService {
	abstract ReturnMessage login(UserVo UserVo);
	
	abstract ReturnMessage getUserPoByCerNum(String cerNum);

	abstract ReturnMessage regist(UserVo userVo);
}
