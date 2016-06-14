package com.oums.service.Impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oums.bean.ReturnMessage;
import com.oums.bean.po.AdminUserPo;
import com.oums.bean.po.UserPo;
import com.oums.bean.type.AdminUserType;
import com.oums.bean.vo.AdminUserVo;
import com.oums.bean.vo.UserVo;
import com.oums.dao.IAdminUserDao;
import com.oums.dao.IUserDao;
import com.oums.service.IAdminUserService;
import com.oums.util.BeanUtil;

@Service("adminUserService")
public class AdminUserServiceImpl implements IAdminUserService {
	
	@Autowired
	IAdminUserDao adminDao;
	@Autowired
	IUserDao userDao;
	@Override
	public ReturnMessage login(AdminUserVo adminVo) {
		ReturnMessage returnMessage = new ReturnMessage();
		AdminUserPo adminPo = adminDao.getAdminByEmplNum(adminVo.getEmployeeNumber());
		
		if(adminPo == null || adminPo.getIsDelete() == true){
			returnMessage.setFlat(false);
			returnMessage.setContent("admin user does not exist");
			return returnMessage;
		}
		
		if(adminVo.getPassword() == adminPo.getPassword()){
			returnMessage.setFlat(true);
			AdminUserVo loginAdminVo = new AdminUserVo();
			BeanUtil.poToVo(adminPo, loginAdminVo);
			returnMessage.setObject(loginAdminVo);
//			switch(adminPo.getPermission()){
//			case AdminUserType.USER_ADMIN: 
//				returnMessage.setContent("USER_ADMIN");
//				return returnMessage;
//			case AdminUserType.FINANCE_ADMIN:
//				returnMessage.setContent("FINANCE_ADMIN");
//				return returnMessage;
//			case AdminUserType.SITE_ADMIN:
//				returnMessage.setContent("SITE_ADMIN");
//				return returnMessage;
//			case AdminUserType.EQUIPMENT_ADMIN:
//				returnMessage.setContent("EQUIPMENT_ADMIN");
//				return returnMessage;
//			case AdminUserType.SUPER_ADMIN_USER:
//				returnMessage.setContent("SUPER_ADMIN_USER");
//				return returnMessage;
//			default:
//				returnMessage.setFlat(false);
//				returnMessage.setContent("unknowed type of admin user");
//				return returnMessage;
//			}
		}else{
			returnMessage.setFlat(false);
			returnMessage.setContent("password error");
		}

		return returnMessage;
	}

	@Override
	public ReturnMessage getAdminPoByEmplNum(String emplNum) {
		AdminUserPo adminPo = adminDao.getAdminByEmplNum(emplNum);
		ReturnMessage returnMessage = new ReturnMessage();
		if(adminPo == null || adminPo.getIsDelete() == true){
			returnMessage.setFlat(false);
			returnMessage.setContent("admin user does not exist");
			return returnMessage;
		}
		returnMessage.setFlat(true);
		returnMessage.setObject(adminPo);
		
		return returnMessage;
	}

	@Override
	public ReturnMessage regist(AdminUserVo adminVo) {
		ReturnMessage returnMessage = new ReturnMessage();
		//check exist
		AdminUserPo testPo = adminDao.getAdminByEmplNum(adminVo.getEmployeeNumber());
		if(testPo != null){
			returnMessage.setFlat(false);
			returnMessage.setContent("admin user already exists");
			return returnMessage;
		}
		
		AdminUserPo adminPo = new AdminUserPo();
		BeanUtil.voToPo(adminVo, adminPo);
		try{
			adminDao.userRegist(adminPo);
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
	public ReturnMessage modifyPassword(String oldPassword, String newPassword, String emplNum) {
		ReturnMessage returnMessage = new ReturnMessage();
		AdminUserPo adminPo = adminDao.getAdminByEmplNum(emplNum);
		if (adminPo == null){
			returnMessage.setFlat(false);
			return returnMessage;
		}
		if(oldPassword.equals(adminPo.getPassword())){
			adminPo.setPassword(newPassword);
			adminDao.modifyPassword(adminPo);
		}
		adminPo = adminDao.getAdminByEmplNum(emplNum);
		if(adminPo.getPassword() == newPassword){
			returnMessage.setFlat(true);
			returnMessage.setContent("modify succeed");
			return returnMessage;
		}else{
			returnMessage.setFlat(false);
			returnMessage.setContent("modify failed");
			return returnMessage;
		}
	}

	@Override
	public ReturnMessage deleteUser(String[] cerNum, String emplNum, String password) {
		ReturnMessage returnMessage = new ReturnMessage();
		UserPo userPo;
		AdminUserPo adminPo = adminDao.getAdminByEmplNum(emplNum);
		if(!adminPo.getPassword().equals(password)){
			returnMessage.setContent("password error");
			returnMessage.setFlat(false);
			return returnMessage;
		}
		try{
			for(int i = 0; i < cerNum.length; i++){
				userPo = userDao.getUserByCerNum(cerNum[i]);
				userPo.setIsDelete(true);
				adminDao.deleteUser(userPo);
			}
		}catch(Exception e){
			returnMessage.setFlat(false);
			return returnMessage;
		}
		returnMessage.setFlat(true);
		returnMessage.setContent("delete succeed");
		return returnMessage;
	}

	@Override
	public ReturnMessage searchUser(String period, String classes, String isTourist, String cerNum) {
		ReturnMessage returnMessage = new ReturnMessage();
		List<UserPo> users;
//		try{
			users = adminDao.searchUser(period, classes, isTourist, cerNum);
//		}catch(Exception e){
//			returnMessage.setContent("errors occurred during searching");
//			returnMessage.setFlat(false);
//			return returnMessage;
//		}
		Iterator<UserPo> it = users.iterator();
		UserVo[] userVoArray = new UserVo[users.size()];
		for(int i = 0; it.hasNext(); i++){
			userVoArray[i] = new UserVo();
			BeanUtil.poToVo(it.next(), userVoArray[i]);
		}
		returnMessage.setObject(userVoArray);
		returnMessage.setFlat(true);
		return returnMessage;
	}

}
