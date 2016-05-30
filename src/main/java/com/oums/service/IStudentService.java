package com.oums.service;

import com.oums.bean.ReturnMessage;
import com.oums.bean.vo.StudentUserVo;


/**
 * 
 * @author Ou
 * service for studentUser login, 
 */
public interface IStudentService {
	public ReturnMessage login(StudentUserVo studentUserVo);
	

}
