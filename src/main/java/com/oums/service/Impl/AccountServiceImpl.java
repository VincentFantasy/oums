package com.oums.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oums.bean.ReturnMessage;
import com.oums.bean.po.AccountPo;
import com.oums.bean.vo.AccountVo;
import com.oums.bean.vo.PaginationVo;
import com.oums.dao.IAccountDao;
import com.oums.dao.IBaseDao;
import com.oums.service.IAccountService;
import com.oums.util.BeanUtil;
import com.oums.util.Pagination;


@Service("accountService")
public class AccountServiceImpl implements IAccountService {
	@Autowired
	IBaseDao baseDao;
	
	@Autowired
	IAccountDao accountDao;

	
	@Override
	public ReturnMessage getAccountFlows(PaginationVo paginationVo) {
		ReturnMessage returnMessage = new ReturnMessage();
		Pagination pagination = accountDao.getAccountFlows(paginationVo);	
	
		
		List<AccountPo> listPo = (List<AccountPo>) pagination.getList();
		
		//Po列表转化昵称Vo列表
		List<AccountVo> listVo = new ArrayList<AccountVo>();
				listPo.stream().forEach(apo -> {
			AccountVo avo = new AccountVo(); 
			BeanUtil.poToVo(apo, avo);
			listVo.add(avo);
		});
		//将VO列表封装到pagination分页封装类中返回
		pagination.setList(listVo);
		returnMessage.setObject(pagination);
		return returnMessage;
	}

	@Override
	public ReturnMessage addAccountFlow(AccountVo accountVo) {
		ReturnMessage returnMessage = new ReturnMessage();
		try {
			AccountPo accountPo = new AccountPo();
			BeanUtil.voToPo(accountVo, accountPo);
			baseDao.add(accountPo);
			returnMessage.setContent("添加成功!");
		} catch (Exception e) {
			returnMessage.setContent("添加失败:"+e);
		}
		return returnMessage;
	}

	@Override
	public ReturnMessage deleteAccountFlow(AccountVo accountVo) {
		ReturnMessage returnMessage = new ReturnMessage();
		try {
		AccountPo accountPo =baseDao.findById(AccountPo.class, accountVo.getFinanceId());
		if(accountPo!=null){
			AccountPo apo =new AccountPo();
			BeanUtil.voToPo(accountVo, apo);
			baseDao.delete(apo);
			returnMessage.setContent("删除成功!");
		}else{
			returnMessage.setContent("删除失败");
		}
		} catch (Exception e) {
			returnMessage.setContent("删除失败,系统异常:"+e);
		}
		return returnMessage;
	}

}
