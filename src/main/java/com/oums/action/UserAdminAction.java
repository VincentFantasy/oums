package com.oums.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.Session;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.oums.bean.ReturnMessage;
import com.oums.bean.po.AdminUserPo;
import com.oums.bean.vo.AdminUserVo;
import com.oums.bean.vo.UserVo;
import com.oums.service.IAdminUserService;
import com.oums.service.IUserService;

/**
 * user admin action
 * @author Zhenghui Ou
 *
 */
@ParentPackage("basePackage")
@Namespace("/")
public class UserAdminAction implements ServletRequestAware{
	
	@Autowired
	IAdminUserService adminService;
	
	/* 可以这样获取参数，要有getset方法 */	
	private UserVo userVo;
	private UserVo[] userArray;
	private AdminUserVo adminVo;
	private HttpServletRequest request = null;
	public AdminUserVo getAdminVo() {
		return adminVo;
	}

	public void setAdminVo(AdminUserVo adminVo) {
		this.adminVo = adminVo;
	}

	public UserVo getUserVo() {
		return userVo;
	}

	public void setUserVo(UserVo user) {
		this.userVo = user;
	}
	
	private ReturnMessage returnMessage;
	
	public ReturnMessage getReturnMessage() {
		return returnMessage;
	}

	public void setReturnMessage(ReturnMessage returnMessage) {
		this.returnMessage = returnMessage;
	}

	public UserVo[] getUserArray() {
		return userArray;
	}

	public void setUserArray(UserVo[] userArray) {
		this.userArray = userArray;
	}
	/**
	 * 用户管理员查询用户
	 */
	@Action(value = "searchUser", results = {
			@Result(name = "success", location="/jsp/userManagement/searchUser.jsp") })
	public String searchUser(){
		String period, classes, isTourist, cerNum;
		if(userVo.getPeriod() == null){
			period = "*";
		}else{
			period = userVo.getPeriod();
		}
		if(userVo.getClasses() == null){
			classes = "*";
		}else{
			classes = userVo.getClasses();
		}
		if(userVo.getIsTourist()){
			isTourist = "true";
		}else{
			isTourist = "false";
		}
		if(userVo.getCertificateNumber() == null){
			cerNum = "*";
		}else{
			cerNum = userVo.getCertificateNumber();
		}
		ReturnMessage returnMessage = adminService.searchUser(period, classes, isTourist, cerNum);
		userArray = (UserVo[])returnMessage.getObject();
		return "success";
	}
	
	@Action(value = "deleteUser", results = {
			@Result(name = "success", location="/jsp/userManagement/searchUser.jsp") })
	public String deleteUser(){
		String[] deleteUserArray = ServletActionContext.getRequest().getParameterValues("deleteUserCheckboxList");
		String[] userCerNumArray = ServletActionContext.getRequest().getParameterValues("userCerNumList");
		for(int i = 0; i < deleteUserArray.length; i++){
			int deleteIndex = Integer.parseInt(deleteUserArray[i]);
			//adminService.deleteUser(userCerNumArray[deleteIndex], emplNum, password)
		}
		return "success";
	}
	
	@Action(value = "adminLogin", results = {
			@Result(name = "success", location = "/jsp/index-m.jsp"),
			@Result(name = "fail", location = "/jsp/userManagement/login.jsp")})
	public String adminLogin(){
		ReturnMessage returnMessage = adminService.login(adminVo);
		if(returnMessage.isFlat() == true){
			this.request.getSession().setAttribute("adminVo", returnMessage.getObject());
			//将管理员vo放入session中
			return "success";
		}else{
			return "fail";
		}
	}
	
	@Action(value = "adminRegist", results = {
			@Result(name = "success", location = "/jsp/index-m.jsp"),
			@Result(name = "fail", location = "/jsp/userManagement/login.jsp")})
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	


}
