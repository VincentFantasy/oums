package com.oums.action;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.oums.service.IUserService;

/**
 * user相关的action
 * @author 谭治
 *
 */
@ParentPackage("basePackage")
@Namespace("/")
public class UserAction {
	
	@Autowired
	IUserService userServer;
	
	/* 加载logger */
	private static Logger logger = LogManager.getLogger(UserAction.class.getName());

	/**
	 * 测试action
	 * http://localhost:8080/OUMS/test
	 */
	@Action(value="test", results={@Result(name = "success", location = "/success.jsp")})	
	public void test() {
		logger.info("进入testAction");
		System.out.println("test()");
		userServer.test();
	}
	
}