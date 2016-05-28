package com.oums.action;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;

import com.oums.bean.ReturnMessage;
import com.oums.bean.vo.UserVo;
import com.oums.service.IUserService;

/**
 * user相关的action
 * @author 谭治
 *
 */
@ParentPackage("basePackage")
@Namespace("/userManager")
public class UserManagerAction {
	
	@Autowired
	IUserService userServer;
	
	/* 可以这样获取参数，要有getset方法 */	
	private UserVo user;

	public UserVo getUser() {
		return user;
	}

	public void setUser(UserVo user) {
		this.user = user;
	}
	
	private ReturnMessage returnMessage;
	
	public ReturnMessage getReturnMessage() {
		return returnMessage;
	}

	public void setReturnMessage(ReturnMessage returnMessage) {
		this.returnMessage = returnMessage;
	}
}
