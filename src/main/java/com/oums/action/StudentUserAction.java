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
import com.oums.bean.vo.StudentUserVo;
import com.oums.bean.vo.UserVo;
import com.oums.service.IStudentService;
import com.oums.service.IUserService;
import com.oums.util.JsonUtil;
/**
 * 学生用户相关action
 * @author Ou
 *
 */

@ParentPackage("basePackage")
@Namespace("/jsp/userManagement")
public class StudentUserAction {
	
	private static Logger logger = LogManager.getLogger(StudentUserAction.class.getName());
	@Autowired
	private IStudentService studentService;
	
	private StudentUserVo studentUserVo;
	private ReturnMessage returnMessage;
	public ReturnMessage getReturnMessage() {
		return returnMessage;
	}
	public StudentUserVo getStudentUserVo() {
		return studentUserVo;
	}
	public void setStudentUserVo(StudentUserVo studentUserVo) {
		this.studentUserVo = studentUserVo;
	}
	/**
	 * 学生用户登陆action
	 * 
	 */
	@Action(value="studentLogin", results={@Result(name = "success", location = "/jsp/userManagement/studentHome.jsp"), @Result(name = "fail", location = "/jsp/userManagement/login.jsp")})	
	public String studentLogin() {
		logger.info("studentLogin.StudentUserAction");
		returnMessage = studentService.login(studentUserVo);
		if(returnMessage.isFlat()){
			System.out.println(StudentUserAction.class.getName() + "success");
			return "success";
		}
		System.out.println(StudentUserAction.class.getName() + "fail");
			return "fail";
	}
}
