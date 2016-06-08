package com.oums.junit.userManagement;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.oums.bean.ReturnMessage;
import com.oums.bean.vo.UserVo;
import com.oums.junit.BaseUnit;
import com.oums.service.IUserService;

public class UserRegistTest extends BaseUnit{
	
	ReturnMessage returnMessage;
	@Autowired
	IUserService userService;
	@Before
	public void before(){
		returnMessage = new ReturnMessage();
	}
	
	@Test
	public void registTest(){
		UserVo userVo = new UserVo();
		
		userVo.setCertificateNumber("201311911218");
		userVo.setIDCardNumber("440105199501010666");
		userVo.setIsDelete(false);
		userVo.setPassword("1234");
		userVo.setPhone("18344069822");
		userVo.setRealName("ouzhu");
		
		returnMessage = userService.regist(userVo);
		assertEquals(returnMessage.isFlat(),true);
	}
}
