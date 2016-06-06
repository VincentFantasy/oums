package com.oums.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.oums.bean.ReturnMessage;
import com.oums.bean.type.OrderClass;
import com.oums.bean.type.OrderType;
import com.oums.bean.vo.OrderVo;
import com.oums.bean.vo.SiteVo;
import com.oums.bean.vo.UserVo;
import com.oums.service.ISiteService;
import com.oums.service.IUserService;
import com.oums.util.OrderUtil;

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
	
	@Autowired
	IUserService userService;
		
	private SiteVo site;
	
	private ReturnMessage returnMessage;
		
	private OrderVo order;
	
	private UserVo user;

	public UserVo getUser() {
		return user;
	}

	public void setUser(UserVo user) {
		this.user = user;
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

	public OrderVo getOrder() {
		return order;
	}

	public void setOrder(OrderVo order) {
		this.order = order;
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
	
	
	/**
	 * 新的场地订单
	 * @return
	 * http://localhost:8080/OUMS/site/findSite
	 */
	@Action(value="newSiteOrder", results={@Result(name="success", type="json", params={"root","returnMessage"})})
	public String newSiteOrder() {
		
		order.setOrderNumber(OrderUtil.createOrderNumber());
		order.setIsDelete(false);
		order.setOrderType(OrderType.NOPAY);
		order.setOrderClass(OrderClass.SITE);
		
		//设置用户
//		
//		order.setUser((UserPo) userService.findUserByName(user).getObejt());
		
		returnMessage = siteService.addSiteOrder(order);
		
		return "success";
	}
	
	/**
	 * 更加场地名查找场地的周表
	 * @return
	 * http://localhost:8080/OUMS/site/findWeekBySite
	 */
	@Action(value="findWeekBySite", results={@Result(name="success", type="json", params={"root","returnMessage"})})
	public String findWeekBySite() {
		
		returnMessage = siteService.findWeekBySite(site);
		
		return "success";
	}
	
}
