package com.oums.service;

import com.oums.bean.ReturnMessage;
import com.oums.bean.vo.GonggaoVo;

public interface IGonggaoService {

	/**
	 * 添加公告
	 * @param vo
	 * @return
	 */
	ReturnMessage addGonggao(GonggaoVo vo);
	
	/**
	 * 删除公告
	 * @param vo
	 * @return
	 */
	ReturnMessage deleteGonggao(GonggaoVo vo);
	
	/**
	 * 查找公告
	 * @return
	 */
	ReturnMessage findGonggaoById(GonggaoVo vo);
	
	/**
	 * 所有公告
	 * @return
	 */
	ReturnMessage getAllGonggao();
	
}
