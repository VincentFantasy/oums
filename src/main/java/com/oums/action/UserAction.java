package com.oums.action;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
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
@Namespace("/user")
public class UserAction {
	
	@Autowired
	IUserService userServer;
	
	/* 加载logger */
	private static Logger logger = LogManager.getLogger(UserAction.class.getName());
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

	/**
	 * 注册 这种返回json字符串
	 * @return
	 * http://localhost:8080/OUMS/user/register
	 */
	@Action(value="register")
	public void register() {
		logger.info("进入register()方法");		

		returnMessage = userServer.addUser(user);    
        
		//打印
		System.out.println(returnMessage);
		
		logger.info("退出register()方法" + returnMessage);
	}
	
}
