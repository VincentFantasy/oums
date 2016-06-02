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

import com.oums.bean.ReturnMessage;
import com.oums.bean.vo.UserVo;
import com.oums.service.IUserService;
import com.oums.util.JsonUtil;
/**
 * 学生用户相关action
 * @author Ou
 *
 */

@ParentPackage("basePackage")
@Namespace("/user")
public class UserAction {
	
	private static Logger logger = LogManager.getLogger(UserAction.class.getName());
	@Autowired
	private IUserService userService;
	
	private UserVo userVo;
	private ReturnMessage returnMessage;
	public ReturnMessage getReturnMessage() {
		return returnMessage;
	}
	public UserVo getUserVo() {
		return userVo;
	}
	public void setUserVo(UserVo userVo) {
		this.userVo = userVo;
	}
	/**
	 * 学生用户登陆action
	 * 
	 */
	@Action(value="userLogin", results={@Result(name = "success", location = "/jsp/userManagement/userHome.jsp"), @Result(name = "fail", location = "/jsp/userManagement/login.jsp")})	
	public String studentLogin() {
		returnMessage = userService.login(userVo);
		if(returnMessage.isFlat()){
			return "success";
		}
		System.out.println(UserAction.class.getName() + "fail");
			return "fail";
	}
}
