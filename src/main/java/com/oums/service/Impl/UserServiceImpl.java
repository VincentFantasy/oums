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
		
		return returnMessage;
	}

}
