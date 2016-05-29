package com.oums.service.Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oums.bean.ReturnMessage;
import com.oums.bean.po.StudentUserPo;
import com.oums.bean.vo.StudentUserVo;
import com.oums.dao.IStudentUserDao;
import com.oums.service.IStudentService;
/**
 * 
 * @author Ou
 *
 */
@Service ("studentService")
public class StudentServiceImpl implements IStudentService{
	
	@Autowired
	IStudentUserDao studentUserDao;
	
	@Override
	public ReturnMessage login(StudentUserVo studentUserVo){
		ReturnMessage returnMessage = new ReturnMessage();
		StudentUserPo stdPo = studentUserDao.getStuUserByStuNum(studentUserVo.getStudentNumber());
		
		if(stdPo == null){
			returnMessage.setFlat(false);
			returnMessage.setContent("该用户不存在");
			return returnMessage;
		}
		
		if(stdPo.getPassword() == studentUserVo.getPassword()){
			returnMessage.setFlat(true);
		}else{
			returnMessage.setFlat(false);
			returnMessage.setContent("密码错误");
		}

		return returnMessage;
	}
	
}
