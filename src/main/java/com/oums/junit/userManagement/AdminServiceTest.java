package com.oums.junit.userManagement;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.oums.bean.ReturnMessage;
import com.oums.bean.type.AdminUserType;
import com.oums.bean.vo.AdminUserVo;
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
}
