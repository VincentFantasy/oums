package com.oums.dao;

import com.oums.bean.po.StudentUserPo;
import com.oums.bean.po.UserPo;

public interface IStudentUserDao {
	abstract StudentUserPo getStuUserByStuNum(String stuNum);
}
