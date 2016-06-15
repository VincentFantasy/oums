package com.oums.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.oums.bean.Page;
import com.oums.bean.ReturnMessage;
import com.oums.bean.po.OrderPo;
import com.oums.bean.po.RacePo;
import com.oums.bean.vo.RaceVo;
import com.oums.service.IRaceService;

/**
 * 
 * @author Fantasy
 *
 */
@ParentPackage("basePackage")
@Namespace("/jsp/race")
public class RaceAction {

	@Autowired
	IRaceService raceService;
	
	private RaceVo race;
	
	private ReturnMessage returnMessage;
	
	private Page page; 

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
	
	public ReturnMessage getReturnMessage() {
		return returnMessage;
	}

	public void setReturnMessage(ReturnMessage returnMessage) {
		this.returnMessage = returnMessage;
	}

	public RaceVo getRace() {
		return race;
	}

	public void setRace(RaceVo race) {
		this.race = race;
	}

	/**
	 * 查找场地
	 * 
	 * @return http://localhost:8080/OUMS/jsp/site/findRace
	 */
	@Action(value = "findRace", results = {
			@Result(name = "success", type = "json", params = { "root", "returnMessage" }) })
	public String findRace() {

		returnMessage = raceService.findRaceByName(race);

		return "success";

	}
	
	/**
	 * 查找场地
	 * 
	 * @return http://localhost:8080/OUMS/jsp/site/findLikeRace
	 */
	@Action(value = "findLikeRace", results = {
			@Result(name = "success", type = "json", params = { "root", "returnMessage" }) })
	public String findLikeRace() {

		returnMessage = raceService.findRaceLikeName(race);

		@SuppressWarnings("unchecked")
		List<RacePo> list = (List<RacePo>) returnMessage.getObject();
		page.setRecordCount(list.size());
		list = page.thisPageData(list);
		returnMessage.setObject(list);
		returnMessage.setPageCount(page.getPageCount());
				
		return "success";

	}

}
