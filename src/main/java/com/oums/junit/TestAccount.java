package com.oums.junit;


import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import com.oums.bean.ReturnMessage;
import com.oums.bean.vo.AccountVo;
import com.oums.dao.IAccountDao;
import com.oums.dao.IBaseDao;
import com.oums.service.IAccountService;

public class TestAccount extends BaseJunit4Test{
	@Autowired
	IBaseDao baseDao;
	@Autowired
	IAccountDao accountDao;
	@Autowired
	IAccountService accountService;
	
	@Test
	public void testGetAccountFlows(){
		AccountVo accountVo = new AccountVo();
		accountVo.setAccount_balance(111.1);
		accountVo.setDelete(true);
		accountVo.setFlow_account(12.1);
		accountVo.setFlow_detail("abc");
		accountVo.setFlow_type("321");
		accountVo.setTime(new Date());
	ReturnMessage returnMessage = 	accountService.addAccountFlow(accountVo);
	System.out.println(returnMessage.getContent());
	}

}
