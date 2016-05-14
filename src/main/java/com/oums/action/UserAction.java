package com.oums.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.oums.bean.vo.UserVo;
import com.oums.service.IUserService;
import com.oums.util.JsonUtil;

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
	/* 可以这样获取参数，要有getset方法 */
	private String username;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	private UserVo user;

	public UserVo getUser() {
		return user;
	}

	public void setUser(UserVo user) {
		this.user = user;
	}

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
	
	/**
	 * 测试action
	 * http://localhost:8080/OUMS/testForm
	 */
	@Action(value="testForm", results={@Result(name = "success", location = "/success.jsp")})
	public String testForm() {
		System.out.println("testForm(),username:" + username);
		return "success";
	}
	
	/**
	 * 注册 , 这种直接返回json对象，需要前端处理
	 * @return
	 * http://localhost:8080/OUMS/testJson
	 */
	@Action(value="testJson", results={@Result(name="success", type="json", params={"root","user"})})
	public String testJson() {
		logger.info("进入testJson()方法");
		
		System.out.println("testJson()");
		System.out.println("username:" + user.getUserName());
//		ReturnMessage returnMessage = userServer.addUser(user);
		
		logger.info("退出testJson()方法");
		return "success";
	}
	
	/**
	 * 注册 , 这种直接返回json对象，需要前端处理
	 * @return
	 * http://localhost:8080/OUMS/register
	 */
	@Action(value="register", results={@Result(name="success", type="json", params={"root","user"})})
	public String register() {
		logger.info("进入register()方法");
		
		System.out.println("username:" + user.getUserName());
		System.out.println("password:" + user.getPassword());
//		ReturnMessage returnMessage = userServer.addUser(user);
		
		logger.info("退出register()方法");
		return "success";
	}
	
	/**
	 * 注册 这种返回json字符串
	 * @return
	 * http://localhost:8080/OUMS/register
	 */
	@Action(value="register2")
	public void register2() {
		logger.info("进入register()方法");
		
		System.out.println("username:" + user.getUserName());
		System.out.println("password:" + user.getPassword());
//		ReturnMessage returnMessage = userServer.addUser(user);
		
		HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("text/html;charset=UTF8");
        PrintWriter out = null;
        try {
			out = response.getWriter();
			out.println(JsonUtil.toJson(user));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			out.flush();
	        out.close();
		}      
        
        
		logger.info("退出register()方法");
	}
	
}
