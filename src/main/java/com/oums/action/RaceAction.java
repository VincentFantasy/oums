package com.oums.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.oums.bean.ReturnMessage;
import com.oums.bean.po.OrderPo;
import com.oums.bean.po.SitePo;
import com.oums.bean.po.UserPo;
import com.oums.bean.type.ItemState;
import com.oums.bean.type.OrderClass;
import com.oums.bean.type.OrderType;
import com.oums.bean.vo.OrderVo;
import com.oums.bean.vo.RaceVo;
import com.oums.bean.vo.SiteVo;
import com.oums.bean.vo.UserVo;
import com.oums.service.IOrderService;
import com.oums.service.IRaceService;
import com.oums.service.ISiteService;
import com.oums.service.IUserService;
import com.oums.util.OrderUtil;
import com.oums.util.TimeUtil;

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

		return "success";

	}

}
