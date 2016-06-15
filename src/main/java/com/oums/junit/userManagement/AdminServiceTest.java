package com.oums.junit.userManagement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.oums.bean.ReturnMessage;
import com.oums.bean.po.AdminUserPo;
import com.oums.bean.type.AdminUserType;
import com.oums.bean.vo.AdminUserVo;
import com.oums.bean.vo.UserVo;
import com.oums.junit.BaseUnit;
import com.oums.service.IAdminUserService;

public class AdminServiceTest extends BaseUnit{
	ReturnMessage returnMessage;
	@Autowired
	IAdminUserService adminService;
	@Before
	public void before(){
		returnMessage = new ReturnMessage();
	}
	
	@Test
	public void registTest(){
		AdminUserVo adminVo = new AdminUserVo();
		
		adminVo.setEmployeeNumber("10001");
		adminVo.setIDCardNumber("440105199501010001");
		adminVo.setIsDelete(false);
		adminVo.setPassword("1234");
		adminVo.setPhone("18344069822");
		adminVo.setRealName("sezhi");
		adminVo.setPermission(AdminUserType.SUPER_ADMIN_USER);
		
		returnMessage = adminService.regist(adminVo);
		assertEquals(returnMessage.isFlat(),true);
	}
	
	@Test
	public void modifyPasswordTest(){
		AdminUserPo adminPo = (AdminUserPo)adminService.getAdminPoByEmplNum("10001").getObject();
		assertEquals(adminPo.getPassword(),"1234");
		ReturnMessage returnMessage = adminService.modifyPassword("1234", "12345", "10001");
		assertTrue(returnMessage.isFlat());
		adminPo = (AdminUserPo)adminService.getAdminPoByEmplNum("10001").getObject();
		assertEquals(adminPo.getPassword(),"12345");
	}
	
//	@Test
//	public void deleteUserTest(){
//		String[] users = new String[2]; 
//		users[0] = "201311911210";
//		users[1] = "201311911216";
//		returnMessage = adminService.deleteUser(users, "10001", "12345");
//		assertEquals(returnMessage.isFlat(), true);
//		assertEquals(returnMessage.getContent(), "delete succeed");
//		returnMessage = adminService.deleteUser(users, "10001", "1234");
//		assertEquals(returnMessage.isFlat(), false);
//	}
	
	@Test
	public void searchUserTest(){
		returnMessage = adminService.searchUser("*", "*", "true", "*");
		System.out.println("!");
		System.out.println("!");
		System.out.println("!");
		System.out.println("!");
		System.out.println("!");
		UserVo[] users = (UserVo[])returnMessage.getObject();
		for(int i = 0; i < users.length; i++){
			System.out.println(users[i].toString());
		}
		System.out.println("!");
		System.out.println("!");
		System.out.println("!");
		System.out.println("!");
		System.out.println("!");
	}
}
