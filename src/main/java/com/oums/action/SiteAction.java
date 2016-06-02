package com.oums.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.oums.bean.ReturnMessage;
import com.oums.bean.vo.SiteVo;
import com.oums.service.ISiteService;

/**
 * 
 * @author 谭治
 *
 */
@ParentPackage("basePackage")
@Namespace("/site")
public class SiteAction {
	
	@Autowired
	ISiteService siteService;
		
	private SiteVo site;

	public SiteVo getSite() {
		return site;
	}

	public void setSite(SiteVo site) {
		this.site = site;
	}
	
	private ReturnMessage returnMessage;
	
	public ReturnMessage getReturnMessage() {
		return returnMessage;
	}

	public void setReturnMessage(ReturnMessage returnMessage) {
		this.returnMessage = returnMessage;
	}
	
	/**
	 * 查找场地
	 * @return
	 * http://localhost:8080/OUMS/site/findSite
	 */
	@Action(value="findSite", results={@Result(name="success", type="json", params={"root","returnMessage"})})
	public String findSite() {		
		
		returnMessage = siteService.findSiteByName(site.getSiteName());
		
		return "success";
	
	}
	
	/**
	 * 根据场地类型查找场地
	 * @return
	 * http://localhost:8080/OUMS/site/findSite
	 */
	@Action(value="findSiteType", results={@Result(name="success", type="json", params={"root","returnMessage"})})
	public String findSiteType() {
		
		returnMessage = siteService.findSiteByType(site.getSiteType());
		
		return "success";
	}

	
}
