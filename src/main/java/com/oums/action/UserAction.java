package com.oums.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
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
@Namespace("/")
public class UserAction implements ServletRequestAware{
	
	private static Logger logger = LogManager.getLogger(UserAction.class.getName());
	@Autowired
	private IUserService userService;
	private HttpServletRequest request = null;
	private UserVo userVo;
	private ReturnMessage returnMessage;
	private String oldPassword;
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	private String newPassword;
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
	 * 用户登录
	 * 
	 */
	@Action(value="userLogin", results={@Result(name = "success", location = "/index.jsp"), @Result(name = "fail", location = "/jsp/userManagement/login.jsp")})	
	public String userLogin() {
		returnMessage = userService.login(userVo);
		if(returnMessage.isFlat()){
			UserVo userVo = (UserVo)returnMessage.getObject();
			this.request.getSession().setAttribute("userVo", userVo);
			return "success";
		}
		System.out.println(UserAction.class.getName() + "fail");
			return "fail";
	}
	/**
	 * 用户管理员注册用户
	 * @return
	 */
	@Action(value="userRegister", results={
			@Result(name = "success", location = "success.jsp"), 
			@Result(name = "fail", location = "fail.jsp"),
			@Result(name = "exist", location = "exist.jsp"),})	
	public String userRegist() {
		returnMessage = userService.regist(userVo);
		if(returnMessage.isFlat()){
			return "success";
		}else if(returnMessage.getContent().equals("user already exists")){
			return "exist";
		}else{
			return "fail";
		}
		
	}
	/**
	 * 用户修改密码
	 * @return
	 */
	@Action(value="userModifyPassword", results={
			@Result(name = "success", location = "success.jsp"), 
			@Result(name = "fail", location = "fail.jsp")})	
	public String userModifyPassword() {
		UserVo userVo = (UserVo)this.request.getSession().getAttribute("userVo");
		String cerNum = userVo.getCertificateNumber();
		returnMessage = userService.modifyPassword(oldPassword, newPassword, cerNum);
		if(returnMessage.isFlat()){
			return "success";
		}else{
			return "fail";
		}
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

}
