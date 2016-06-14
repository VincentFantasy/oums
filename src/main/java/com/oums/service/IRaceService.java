package com.oums.service;

import com.oums.bean.ReturnMessage;
import com.oums.bean.vo.RaceVo;

/**
 * 赛事Service
 * @author Fantasy
 *
 */
public interface IRaceService {

	/**
	 * 根据名字查询赛事
	 * @return
	 */
	ReturnMessage findRaceByName(RaceVo vo);
	
	/**
	 * 根据名字模糊查询赛事 , 把名字装进VO里
	 * @param vo
	 * @return
	 */
	ReturnMessage findRaceLikeName(RaceVo vo);
	
}
