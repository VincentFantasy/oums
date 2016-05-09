package com.oums.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.oums.service.IUserService;
import com.oums.util.JsonUtil;

@ParentPackage("basePackage")
@Namespace("/")
public class UserAction {
	
	@Autowired
	IUserService userServer;
	
//	Log

	/**
	 * http://localhost:8080/OUMS/test
	 */
	@Action(value="test", results={@Result(name = "success", location = "/success.jsp")})	
	public void test() {
		System.out.println("½øÈëtest()");
		userServer.test();
	}
	
}
