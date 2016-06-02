package com.oums.service.Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oums.bean.ReturnMessage;
import com.oums.bean.po.UserPo;
import com.oums.bean.vo.UserVo;
import com.oums.dao.IUserDao;
import com.oums.service.IUserService;
/**
 * 
 * @author Ou
 *
 */
@Service ("userService")
public class UserServiceImpl implements IUserService{
	
	@Autowired
	IUserDao userDao;
	
	@Override
	public ReturnMessage login(UserVo userVo){
		ReturnMessage returnMessage = new ReturnMessage();
		UserPo stdPo = userDao.getUserByCerNum(userVo.getCertificateNumber());
		
		if(stdPo == null){
			returnMessage.setFlat(false);
			returnMessage.setContent("该用户不存在");
			return returnMessage;
		}
		
		if(stdPo.getPassword() == userVo.getPassword()){
			returnMessage.setFlat(true);
		}else{
			returnMessage.setFlat(false);
			returnMessage.setContent("密码错误");
		}

		return returnMessage;
	}
	
}
