package com.oums.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.oums.bean.ReturnMessage;
import com.oums.bean.po.AdminUserPo;
import com.oums.bean.po.OrderPo;
import com.oums.bean.type.AdminUserType;
import com.oums.bean.type.OrderType;
import com.oums.bean.vo.AdminUserVo;
import com.oums.bean.vo.DayVo;
import com.oums.bean.vo.OrderVo;
import com.oums.bean.vo.SiteVo;
import com.oums.bean.vo.WeekVo;
import com.oums.dao.IOrderDao;
import com.oums.service.IAdminUserService;
import com.oums.service.IOrderService;
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

	@Autowired
	IOrderService orderService;

	@Autowired
	IAdminUserService adminUserService;

	private SiteVo site;

	private WeekVo week;

	private DayVo day;

	private ReturnMessage returnMessage;

	private OrderVo order;

	private AdminUserVo adminUser;

	public AdminUserVo getAdminUser() {
		return adminUser;
	}

	public void setAdminUser(AdminUserVo adminUser) {
		this.adminUser = adminUser;
	}

	public OrderVo getOrder() {
		return order;
	}

	public void setOrder(OrderVo order) {
		this.order = order;
	}

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
	 * 
	 * @return http://localhost:8080/OUMS/siteManager/addSite
	 */
	@Action(value = "addSite", results = {
			@Result(name = "success", type = "json", params = { "root", "returnMessage" }) })
	public String addSite() {

		// 查看用戶名是否重複
		returnMessage = siteService.findSiteByName(site.getSiteName());
		if (!returnMessage.isFlat()) {
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
			 * 
			 * @return http://localhost:8080/OUMS/siteManager/testAddSite
			 *//*
			 * @Action(value="testAddSite", results={@Result(name="success",
			 * type="json", params={"root","returnMessage"})}) public String
			 * testAddSite() {
			 * 
			 * SiteVo vo = new SiteVo(); vo.setSiteName("球場1");
			 * vo.setSiteType(SiteType.BADMINTON); vo.setSiteCost(10.0f);
			 * vo.setSiteDtail("詳細"); returnMessage =
			 * siteManagerService.addSite(vo);
			 * 
			 * return "success"; }
			 */

	/**
	 * 添加场地,需要提供场地的名字
	 * 
	 * @return http://localhost:8080/OUMS/siteManager/deleteSite
	 */
	@Action(value = "deleteSite", results = {
			@Result(name = "success", type = "json", params = { "root", "returnMessage" }) })
	public String deleteSite() {

		returnMessage = siteManagerService.deleteSite(site);

		return "success";
	}

	/**
	 * 更新场地
	 * 
	 * @return http://localhost:8080/OUMS/siteManager/updateSite
	 */
	@Action(value = "updateSite", results = {
			@Result(name = "success", type = "json", params = { "root", "returnMessage" }) })
	public String updateSite() {

		returnMessage = siteManagerService.updateSite(site);

		return "success";
	}

	/**
	 * 更改场地类型
	 * 
	 * @return http://localhost:8080/OUMS/siteManager/updateSiteType
	 */
	@Action(value = "updateSiteType", results = {
			@Result(name = "success", type = "json", params = { "root", "returnMessage" }) })
	public String updateSiteType() {

		returnMessage = siteManagerService.updateSiteType(site, week, day);

		return "success";
	}

	/**
	 * 查询全部场地订单
	 * 
	 * @return http://localhost:8080/OUMS/siteManager/findAllSiteOrder
	 */
	@Action(value = "findAllSiteOrder", results = {
			@Result(name = "success", type = "json", params = { "root", "returnMessage" }) })
	public String findAllSiteOrder() {

		returnMessage = siteManagerService.findAllSiteOrder();

		return "success";
	}

	/**
	 * 确认订单
	 * 
	 * @return http://localhost:8080/OUMS/siteManager/sureSiteOrder
	 */
	@Action(value = "sureSiteOrder", results = {
			@Result(name = "success", type = "json", params = { "root", "returnMessage" }) })
	public String sureSiteOrder() {
		// 找出订单		
		returnMessage = orderService.findOrderByNumber(order);

		if (returnMessage.isFlat()) {
			OrderPo po = (OrderPo) returnMessage.getObject();

			// 未付款订单
			if (po.getOrderType() == OrderType.WAITSURE) {
				// 找出管理员，再操作
				returnMessage = adminUserService.getAdminPoByEmplNum(adminUser.getEmployeeNumber());
				if (returnMessage.isFlat()) {
					AdminUserPo adminUserPo = (AdminUserPo) returnMessage.getObject();
					
					//查询权限
					if(adminUserPo.getPermission() == AdminUserType.SITE_ADMIN) {
						po.setOrderType(OrderType.SURE);
						returnMessage = siteManagerService.updateSiteOrderType(po, adminUserPo);
					} else {
						returnMessage = new ReturnMessage();
						returnMessage.setFlat(false);
						returnMessage.setContent("权限出错");
					}
				}
			} else {
				returnMessage = new ReturnMessage();
				returnMessage.setFlat(false);
				returnMessage.setContent("不是等待确认的订单");
			}
		}

		return "success";
	}

	/**
	 * 按类型查询场地订单
	 * 
	 * @return http://localhost:8080/OUMS/siteManager/findSiteOrderByType
	 */
	@Action(value = "findSiteOrderByType", results = {
			@Result(name = "success", type = "json", params = { "root", "returnMessage" }) })
	public String findSiteOrderByType() {

		returnMessage = siteManagerService.findSiteOrderByType(order);

		return "success";
	}

	/**
	 * 拒绝订单
	 * 
	 * @return http://localhost:8080/OUMS/siteManager/rejectOrder
	 */
	@Action(value = "rejectOrder", results = {
			@Result(name = "success", type = "json", params = { "root", "returnMessage" }) })
	public String rejectOrder() {
		// 找出订单		
				returnMessage = orderService.findOrderByNumber(order);

				if (returnMessage.isFlat()) {
					OrderPo po = (OrderPo) returnMessage.getObject();

					// 未付款订单
					if (po.getOrderType() == OrderType.NOPAY) {
						// 找出管理员，再操作
						returnMessage = adminUserService.getAdminPoByEmplNum(adminUser.getEmployeeNumber());
						if (returnMessage.isFlat()) {
							AdminUserPo adminUserPo = (AdminUserPo) returnMessage.getObject();
							
							//查询权限
							if(adminUserPo.getPermission() == AdminUserType.SITE_ADMIN) {
								po.setOrderType(OrderType.REFUSE);
								returnMessage = siteManagerService.updateSiteOrderType(po, adminUserPo);
							} else {
								returnMessage = new ReturnMessage();
								returnMessage.setFlat(false);
								returnMessage.setContent("权限出错");
							}
						}
					} else {
						returnMessage = new ReturnMessage();
						returnMessage.setFlat(false);
						returnMessage.setContent("不是等待确认的订单");
					}
				}

				return "success";
	}
}
