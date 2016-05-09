package com.oums.dao;

import java.io.Serializable;

import com.oums.bean.po.BasePo;

public interface IBaseDao {
	
	/**
	 * 增
	 * @param po
	 * @return
	 */
	abstract <T extends BasePo> Serializable add(T po); 
	
	/**
	 * 删
	 * @param po
	 */
	abstract <T extends BasePo> void delete(T po); 
	
	/**
	 * 查(根据Id)
	 * @param id
	 * @return
	 */
	abstract <T extends BasePo> T findById(Class<T> poClass, Integer id);
	
	/**
	 * 改
	 * @param po
	 */
	abstract <T extends BasePo> void update(T po); 
}
