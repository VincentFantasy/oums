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
	private AdminUserVo[] adminArray;
	private AdminUserVo adminVo;
	private HttpServletRequest request = null;
	private String oldPassword;
	private String newPassword;
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

	public void setUserArray(UserVo[] userArray) {
		this.userArray = userArray;
	}
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public AdminUserVo[] getAdminArray() {
		return adminArray;
	}

	public void setAdminArray(AdminUserVo[] adminArray) {
		this.adminArray = adminArray;
	}
	/**
	 * 用户管理员查询用户
	 */
	@Action(value = "searchUser", results = {
			@Result(name = "success", location="/jsp/userManagement/admin/searchUser.jsp") })
	public String searchUser(){
		String period, classes, isTourist, cerNum;
		int userArrayLength = 0;
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
		UserVo[] tempArray = (UserVo[])returnMessage.getObject();
		for(int i = 0; i < tempArray.length; i++){
			if(!tempArray[i].getIsDelete()){
				userArrayLength++;
			}
		}
		userArray = new UserVo[userArrayLength];
		for(int i = 0, j = 0; i < tempArray.length; i++, j++){
			if(!tempArray[i].getIsDelete()){
				userArray[j] = tempArray[i];
			}else{
				j--;
			}
		}
		return "success";
	}
	/**
	 * 超级用户查询管理员用户
	 * @return
	 */
	@Action(value = "searchAdmin", results = {
			@Result(name = "success", location="/jsp/userManagement/superUser/searchAdminUser.jsp") })
	public String searchAdmin(){
		ReturnMessage returnMessage = adminService.searchAdmin(adminVo.getPermission(), adminVo.getEmployeeNumber());
		adminArray = (AdminUserVo[])returnMessage.getObject();
		return "success";
	}
	
	/**
	 * 删除用户
	 * @return
	 */
	@Action(value = "deleteUser", results = {
			@Result(name = "success", location="/jsp/userManagement/admin/searchUser.jsp") })
	public String deleteUser(){
		String[] deleteUserArray = ServletActionContext.getRequest().getParameterValues("deleteUserCheckboxList");
		String[] userCerNumArray = ServletActionContext.getRequest().getParameterValues("userCerNumList");
		for(int i = 0; i < deleteUserArray.length; i++){
			int deleteIndex = Integer.parseInt(deleteUserArray[i]);
			adminService.deleteUser(userCerNumArray[deleteIndex]);
		}
		return "success";
	}
	
	/**
	 * 删除用户
	 * @return
	 */
	@Action(value = "deleteAdmin", results = {
			@Result(name = "success", location="/jsp/userManagement/admin/searchAdminUser.jsp") })
	public String deleteAdmin(){
		String[] deleteUserArray = ServletActionContext.getRequest().getParameterValues("deleteUserCheckboxList");
		String[] userCerNumArray = ServletActionContext.getRequest().getParameterValues("userCerNumList");
		for(int i = 0; i < deleteUserArray.length; i++){
			int deleteIndex = Integer.parseInt(deleteUserArray[i]);
			adminService.deleteUser(userCerNumArray[deleteIndex]);
		}
		return "success";
	}
	/**
	 * 管理员登陆
	 * @return
	 */
	@Action(value = "adminLogin", results = {
			@Result(name = "success", location = "/index-m.jsp"),
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
	
	/**
	 * 超级用户注册管理员
	 * @return
	 */
	@Action(value = "adminRegister", results = {
			@Result(name = "success", location = "/jsp/userManagement/admin/success.jsp"),
			@Result(name = "exist", location = "/jsp/userManagement/admin/exist.jsp"),
			@Result(name = "fail", location = "/jsp/userManagement/admin/fail.jsp")})
	public String adminRegister(){
		ReturnMessage returnMessage = adminService.regist(adminVo);
		if(returnMessage.isFlat()){
			return "success";
		}else{
			if(returnMessage.getContent().equals("admin user already exists")){
				return "exist";
			}else{
				return "fail";
			}
		}
		
	}

	/**
	 * 管理员修改密码
	 * @return
	 */
	@Action(value="adminModifyPassword", results={
			@Result(name = "success", location = "/jsp/userManagement/admin/success.jsp"), 
			@Result(name = "fail", location = "/jsp/userManagement/admin/fail.jsp")})	
	public String userModifyPassword() {
		AdminUserVo adminVo = (AdminUserVo)this.request.getSession().getAttribute("adminVo");
		String emplNum = adminVo.getEmployeeNumber();
		returnMessage = adminService.modifyPassword(oldPassword, newPassword, emplNum);
		if(returnMessage.isFlat()){
			return "success";
		}else{
			return "fail";
		}
	}

	


}
