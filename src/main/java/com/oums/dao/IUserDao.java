package com.oums.dao;

import com.oums.bean.po.UserPo;

public interface IUserDao {
	abstract UserPo getUserByCerNum(String stuNum);	
}

