package com.oums.junit.userManagement;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.oums.bean.ReturnMessage;
import com.oums.bean.po.UserPo;
import com.oums.service.IUserService;
import com.oums.service.Impl.UserServiceImpl;

public class UserServiceTest {
	IUserService userService;
	@Before
	public void before(){
		 userService = new UserServiceImpl();
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
	
}
