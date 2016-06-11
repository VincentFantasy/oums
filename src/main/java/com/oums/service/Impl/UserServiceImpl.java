package com.oums.service.Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oums.bean.ReturnMessage;
import com.oums.bean.po.UserPo;
import com.oums.bean.vo.UserVo;
import com.oums.dao.IUserDao;
import com.oums.service.IUserService;
import com.oums.util.BeanUtil;
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
			returnMessage.setContent("user does not exist");
			return returnMessage;
		}
		
		if(userPo.getPassword() == userVo.getPassword()){
			returnMessage.setFlat(true);
		}else{
			returnMessage.setFlat(false);
			returnMessage.setContent("password error");
		}

		return returnMessage;
	}
	
	@Override
	public ReturnMessage getUserPoByCerNum(String cerNum){
		UserPo userPo = userDao.getUserByCerNum(cerNum);
		ReturnMessage returnMessage = new ReturnMessage();
		if(userPo == null || userPo.getIsDelete() == true){
			returnMessage.setFlat(false);
			returnMessage.setContent("user does not exist");
			return returnMessage;
		}
		returnMessage.setFlat(true);
		returnMessage.setObject(userPo);
		
		return returnMessage;
	}
	
	public ReturnMessage regist(UserVo userVo){
		ReturnMessage returnMessage = new ReturnMessage();
		//check exist
		UserPo testPo = userDao.getUserByCerNum(userVo.getCertificateNumber());
		if(testPo != null){
			returnMessage.setFlat(false);
			returnMessage.setContent("user already exists");
			return returnMessage;
		}
		
		UserPo userPo = new UserPo();
		BeanUtil.voToPo(userVo, userPo);
		try{
			userDao.userRegist(userPo);
		}catch(Exception e){
			returnMessage.setFlat(false);
			returnMessage.setContent("failed");
			return returnMessage;
		}
		returnMessage.setFlat(true);
		returnMessage.setContent("succeed");
		return returnMessage;
	}

	@Override
	public ReturnMessage modifyPassword(String oldPassword, String newPassword, String cerNum){
		ReturnMessage returnMessage = new ReturnMessage();
		UserPo userPo = userDao.getUserByCerNum(cerNum);
		if (userPo == null){
			returnMessage.setFlat(false);
			return returnMessage;
		}
		if(oldPassword.equals(userPo.getPassword())){
			userPo.setPassword(newPassword);
			userDao.modifyPassword(userPo);
		}
		userPo = userDao.getUserByCerNum(cerNum);
		if(userPo.getPassword() == newPassword){
			returnMessage.setFlat(true);
			returnMessage.setContent("modify succeed");
			return returnMessage;
		}else{
			returnMessage.setFlat(false);
			returnMessage.setContent("modify failed");
			return returnMessage;
		}
	}
	
	
	
}
