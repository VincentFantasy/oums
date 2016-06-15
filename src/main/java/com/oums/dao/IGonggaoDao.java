package com.oums.dao;

import java.util.List;

import com.oums.bean.po.GonggaoPo;

public interface IGonggaoDao {

	/**
	 * 获取所有的公告
	 * @return
	 */
	List<GonggaoPo> getAllGonggao();
	
	
	/**
	 * 模糊查询公告
	 * @return
	 */
	List<GonggaoPo> findGonggaoLikeName(String name);
}
