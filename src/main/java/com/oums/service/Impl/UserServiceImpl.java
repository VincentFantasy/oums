package com.oums.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oums.bean.ReturnMessage;
import com.oums.bean.po.UserPo;
import com.oums.bean.vo.UserVo;
import com.oums.dao.IBaseDao;
import com.oums.dao.IUserDao;
import com.oums.service.IUserService;
import com.oums.util.MD5Util;

@Service("userServer")
public class UserServiceImpl implements IUserService {

	@Autowired
	IBaseDao baseDao;
	
	@Autowired
	IUserDao userDao;

	@Override
	public ReturnMessage addUser(UserVo userVo) {

		ReturnMessage returnMessage = new ReturnMessage();

		if (userVo.getUserName() != null || userVo.getPassword() != null)
			try {
				UserPo po = new UserPo();
				po.setUserName(userVo.getUserName());
				// 加密
				po.setPassword(MD5Util.MD5(userVo.getPassword()));
				baseDao.add(po);
				returnMessage.setFlat(true);
			} catch (Exception e) {
				e.printStackTrace();
				returnMessage.setFlat(false);
				returnMessage.setContent("异常");
			}

		else {
			returnMessage.setFlat(false);
			returnMessage.setContent("用户名或密码不能为空");
		}

		return returnMessage;
	}

	@Override
	public ReturnMessage findUserByUserName(String userName) {
		ReturnMessage returnMessage = new ReturnMessage();
		System.out.println("����server����");
		if(userName != null)
		try{
			System.out.println("����try");
			//��Ҫһ��po vo ת��
			UserPo userPo = userDao.getUserByName(userName);
			UserVo userVo = new UserVo();
			userVo.setUserName(userPo.getUserName());
			userVo.setPassword(userPo.getPassword());
						
			returnMessage.setFlat(true);
			returnMessage.setObject(userVo);
		}catch (Exception e){
			System.out.println("����Exception");
			e.printStackTrace();
		}
		
		return returnMessage;
	}

	@Override
	public ReturnMessage test() {
		System.out.println("testService");
		userDao.test();
		return null;
	}

}
