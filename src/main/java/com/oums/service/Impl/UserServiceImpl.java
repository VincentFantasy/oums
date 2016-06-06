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

		UserPo userPo = userDao.getUserByCerNum(userVo.getCertificateNumber());
		
		if(userPo == null || userPo.getIsDelete() == true){
			returnMessage.setFlat(false);
			returnMessage.setContent("该用户不存在");
			return returnMessage;
		}
		
		if(userPo.getPassword() == userVo.getPassword()){
			returnMessage.setFlat(true);
		}else{
			returnMessage.setFlat(false);
			returnMessage.setContent("密码错误");
		}

		return returnMessage;
	}
	
	@Override
	public ReturnMessage getUserPoByCerNum(String cerNum){
		UserPo userPo = userDao.getUserByCerNum(cerNum);
		ReturnMessage returnMessage = new ReturnMessage();
		if(userPo == null || userPo.getIsDelete() == true){
			returnMessage.setFlat(false);
			returnMessage.setContent("该用户不存在");
			return returnMessage;
		}
		returnMessage.setFlat(true);
		returnMessage.setObject(userPo);
		
		return returnMessage;
	}
	
}
