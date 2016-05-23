package com.oums.action;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.oums.bean.ReturnMessage;
import com.oums.bean.type.SiteType;
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
	
	/* 加载logger */
	private static Logger logger = LogManager.getLogger(SiteAction.class.getName());
	
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
	 * 添加场地
	 * @return
	 * http://localhost:8080/OUMS/site/addSite
	 */
	@Action(value="addSite", results={@Result(name="success", type="json", params={"root","returnMessage"})})
	public String addSite() {
		logger.info("进入addSite()方法");
		
		//查看用戶名是否重複
		returnMessage = siteService.findSiteByName(site.getSiteName());
		if(!returnMessage.isFlat()) {
			returnMessage = siteService.addSite(site);
		} else {
			returnMessage.setFlat(false);
			returnMessage.setContent("用戶名重複");
			returnMessage.setObject(null);
		}
		//在控制台查看
		System.out.println(returnMessage);
		
		logger.info("退出addSite()方法");
		return "success";
	}

	/**
	 * 添加场地
	 * @return
	 * http://localhost:8080/OUMS/site/testAddSite
	 */
	@Action(value="testAddSite", results={@Result(name="success", type="json", params={"root","returnMessage"})})
	public String testAddSite() {
		logger.info("进入addSite()方法");
		
		SiteVo vo = new SiteVo();
		vo.setSiteName("球場1");
		vo.setSiteType(SiteType.SITETYPE_BADMINTON);
		vo.setSiteCost(10.0f);
		vo.setSiteDtail("詳細");
		returnMessage = siteService.addSite(vo);
		
		System.out.println(returnMessage);
		
		logger.info("退出addSite()方法");
		return "success";
	}
	
	/**
	 * 添加场地
	 * @return
	 * http://localhost:8080/OUMS/site/findSite
	 */
	@Action(value="findSite", results={@Result(name="success", type="json", params={"root","returnMessage"})})
	public String findSite() {
		logger.info("进入findSite()方法");
		
		returnMessage = siteService.findSiteByName(site.getSiteName());
		
		logger.info("退出findSite方法");
		return "success";
	}

}
