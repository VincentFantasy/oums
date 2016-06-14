package com.oums.dao;

import java.util.List;

import com.oums.bean.po.RacePo;

/**
 * 赛事Dao
 * @author Fantasy
 *
 */
public interface IRaceDao {

	/**
	 * 根据名字查找赛事
	 * @param name
	 * @return
	 */
	RacePo findRackByName(String name);
	
	/**
	 * 根据名字模糊查询赛事 没做分页
	 * @param name
	 * @return
	 */
	List<RacePo> findRaceLikeName(String name);
	
}
