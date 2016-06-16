package com.oums.service;

import com.oums.bean.ReturnMessage;
import com.oums.bean.vo.AccountVo;
import com.oums.bean.vo.PaginationVo;

public interface IAccountService {
	ReturnMessage getAccountFlows(PaginationVo paginationVo);
	ReturnMessage addAccountFlow(AccountVo accountVo);
	ReturnMessage deleteAccountFlow(AccountVo accountVo);
}
