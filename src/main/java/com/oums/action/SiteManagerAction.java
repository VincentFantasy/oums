package com.oums.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.oums.bean.ReturnMessage;
import com.oums.bean.vo.DayVo;
import com.oums.bean.vo.SiteVo;
import com.oums.bean.vo.WeekVo;
import com.oums.service.ISiteManagerService;
import com.oums.service.ISiteService;

/**
 * 
 * @author 谭治
 *
 */
@ParentPackage("basePackage")
@Namespace("/siteManager")
public class SiteManagerAction {
	
	@Autowired
	ISiteService siteService;
	
	@Autowired
	ISiteManagerService siteManagerService;
		
	private SiteVo site;
	
	private WeekVo week;
	
	private DayVo day;

	private ReturnMessage returnMessage;
		
	public DayVo getDay() {
		return day;
	}

	public void setDay(DayVo day) {
		this.day = day;
	}
	
	public WeekVo getWeek() {
		return week;
	}

	public void setWeek(WeekVo week) {
		this.week = week;
	}

	public SiteVo getSite() {
		return site;
	}

	public void setSite(SiteVo site) {
		this.site = site;
	}

	public ReturnMessage getReturnMessage() {
		return returnMessage;
	}

	public void setReturnMessage(ReturnMessage returnMessage) {
		this.returnMessage = returnMessage;
	}

	/**
	 * 添加场地，费用填了字符串就会变成空值？
	 * @return
	 * http://localhost:8080/OUMS/siteManager/addSite
	 */
	@Action(value="addSite", results={@Result(name="success", type="json", params={"root","returnMessage"})})
	public String addSite() {
		
		//查看用戶名是否重複
		returnMessage = siteService.findSiteByName(site.getSiteName());
		if(!returnMessage.isFlat()) {
			returnMessage = siteManagerService.addSite(site);
		} else {
			returnMessage.setFlat(false);
			returnMessage.setContent("场地名重複");
			returnMessage.setObject(null);
		}
		
		return "success";
	}

/*	*//**
	 * 添加场地
	 * @return
	 * http://localhost:8080/OUMS/siteManager/testAddSite
	 *//*
	@Action(value="testAddSite", results={@Result(name="success", type="json", params={"root","returnMessage"})})
	public String testAddSite() {
		
		SiteVo vo = new SiteVo();
		vo.setSiteName("球場1");
		vo.setSiteType(SiteType.BADMINTON);
		vo.setSiteCost(10.0f);
		vo.setSiteDtail("詳細");
		returnMessage = siteManagerService.addSite(vo);
		
		return "success";
	}*/
	
	/**
	 * 添加场地,需要提供场地的名字
	 * @return
	 * http://localhost:8080/OUMS/siteManager/deleteSite
	 */
	@Action(value="deleteSite", results={@Result(name="success", type="json", params={"root","returnMessage"})})
	public String deleteSite() {
		
		returnMessage = siteManagerService.deleteSite(site);
		
		return "success";
	}
	
	/**
	 * 更新场地
	 * @return
	 * http://localhost:8080/OUMS/siteManager/updateSite
	 */
	@Action(value="updateSite", results={@Result(name="success", type="json", params={"root","returnMessage"})})
	public String updateSite() {
		
		returnMessage = siteManagerService.updateSite(site);
		
		return "success";
	}
	
	/**
	 * 更改场地类型
	 * @return
	 * http://localhost:8080/OUMS/siteManager/updateSiteType
	 */
	@Action(value="updateSiteType", results={@Result(name="success", type="json", params={"root","returnMessage"})})
	public String updateSiteType() {
		
		returnMessage = siteManagerService.updateSiteType(site, week, day);
		
		return "success";
	}
	
}
