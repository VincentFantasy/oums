package com.oums.junit.userManagement;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.oums.bean.ReturnMessage;
import com.oums.bean.po.UserPo;
import com.oums.junit.BaseUnit;
import com.oums.service.IUserService;

public class UserServiceTest extends BaseUnit{
	@Autowired
	IUserService userService;
	@Before
	public void before(){
	}
	
	@Test
	public void getUserPoByCerNumTest(){
		
		ReturnMessage returnMessage1 = userService.getUserPoByCerNum("201311911217");
		UserPo userPo1 = (UserPo)returnMessage1.getObject();
		assertEquals(userPo1.getRealName(),"ouzhu");
		assertEquals(userPo1.getPhone(),"12345678900");
		ReturnMessage returnMessage2 = userService.getUserPoByCerNum("123456789000");
		UserPo userPo2 = (UserPo)returnMessage2.getObject();
		assertEquals(userPo2, null);
	}
	
	@Test
	public void modifyPasswordTest(){
		UserPo userPo1 = (UserPo)userService.getUserPoByCerNum("201311911217").getObject();
		assertEquals(userPo1.getPassword(),"1234abcd");
		ReturnMessage returnMessage = userService.modifyPassword("1234abcd", "12345", "201311911217");
		assertTrue(returnMessage.isFlat());
		userPo1 = (UserPo)userService.getUserPoByCerNum("201311911217").getObject();
		assertEquals(userPo1.getPassword(),"12345");
	}
	
}
