package com.oums.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.oums.bean.ReturnMessage;
import com.oums.bean.vo.AccountVo;
import com.oums.bean.vo.PaginationVo;
import com.oums.service.IAccountService;

/**
 * 
 *
 */
@ParentPackage("basePackage")
@Namespace("/jsp/accountManager")
public class AccountAction {

	@Autowired
	IAccountService accountService;
	
	private PaginationVo paginationVo;
	private AccountVo accountVo;
	private ReturnMessage returnMessage;
	public AccountVo getAccountVo() {
		return accountVo;
	}
	public void setAccountVo(AccountVo accountVo) {
		this.accountVo = accountVo;
	}
	public ReturnMessage getReturnMessage() {
		return returnMessage;
	}
	public void setReturnMessage(ReturnMessage returnMessage) {
		this.returnMessage = returnMessage;
	}
	 
	public PaginationVo getPaginationVo() {
		return paginationVo;
	}
	public void setPaginationVo(PaginationVo paginationVo) {
		this.paginationVo = paginationVo;
	}
	
	@Action(value = "getAccountFlows", results = {
			@Result(name = "success", type = "json", params = { "getAccountFlows", "returnMessage" }) })
			public String getAccountFlows(){
				returnMessage = accountService.getAccountFlows(paginationVo);
				return "success";
			}
	
	@Action(value = "addAccountFlow", results = {
			@Result(name = "success", type = "json", params = { "addAccountFlow", "returnMessage" }) })
			public String addAccountFlow(){
				returnMessage = accountService.addAccountFlow(accountVo);
				return "success";
			}
	  
	@Action(value = "deleteAccountFlow", results = {
			@Result(name = "success", type = "json", params = { "deleteAccountFlow", "returnMessage" }) })
			public String deleteAccountFlow(){
				returnMessage = accountService.deleteAccountFlow(accountVo);
				return "success";
		}
	
}
