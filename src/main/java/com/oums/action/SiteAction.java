package com.oums.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.oums.bean.ReturnMessage;
import com.oums.bean.po.SitePo;
import com.oums.bean.po.UserPo;
import com.oums.bean.type.ItemState;
import com.oums.bean.type.OrderClass;
import com.oums.bean.type.OrderType;
import com.oums.bean.vo.OrderVo;
import com.oums.bean.vo.SiteVo;
import com.oums.bean.vo.UserVo;
import com.oums.service.ISiteService;
import com.oums.service.IUserService;
import com.oums.util.OrderUtil;
import com.oums.util.TimeUtil;

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

	private int dayOfWeek;

	private int timeInDay;

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

	public void setDayOfWeek(int dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public void setTimeInDay(int timeInDay) {
		this.timeInDay = timeInDay;
	}

	public int getDayOfWeek() {
		return dayOfWeek;
	}

	public int getTimeInDay() {
		return timeInDay;
	}

	/**
	 * 查找场地
	 * 
	 * @return http://localhost:8080/OUMS/site/findSite
	 */
	@Action(value = "findSite", results = {
			@Result(name = "success", type = "json", params = { "root", "returnMessage" }) })
	public String findSite() {

		returnMessage = siteService.findSiteByName(site.getSiteName());

		return "success";

	}

	/**
	 * 根据场地类型查找场地
	 * 
	 * @return http://localhost:8080/OUMS/site/findSiteType
	 */
	@Action(value = "findSiteType", results = {
			@Result(name = "success", type = "json", params = { "root", "returnMessage" }) })
	public String findSiteType() {

		returnMessage = siteService.findSiteByType(site.getSiteType());

		return "success";
	}

	/**
	 * 新的场地订单
	 * 
	 * @return http://localhost:8080/OUMS/site/newSiteOrder
	 */
	@Action(value = "newSiteOrder", results = {
			@Result(name = "success", type = "json", params = { "root", "returnMessage" }) })
	public String newSiteOrder() {

		order = new OrderVo();
		order.setOrderNumber(OrderUtil.createOrderNumber());
		order.setIsDelete(false);
		order.setOrderType(OrderType.NOPAY);
		order.setOrderClass(OrderClass.SITE);
		order.setBuildTime(TimeUtil.getNowTime());

		// 设置用户
		returnMessage = userService.getUserPoByCerNum(user.getCertificateNumber());
		if (returnMessage.isFlat()) {
			UserPo userPo = (UserPo) returnMessage.getObject();
			order.setUser(userPo);

			// 设置场地
			returnMessage = siteService.findSiteByName(site.getSiteName());
			if (returnMessage.isFlat()) {
				SitePo sitePo = (SitePo) returnMessage.getObject();

				// 改变场地周表状态
				if (dayOfWeek < 7 && dayOfWeek > -1 && timeInDay < 6 && timeInDay > -1) {
					sitePo = TimeUtil.changeSiteDayOfWeekState(sitePo, dayOfWeek, timeInDay, ItemState.ORDERED);
					order.getSiteList().add(sitePo);

					// 添加场地
					returnMessage = siteService.addSiteOrder(order, sitePo);
				} else {
					returnMessage.setFlat(false);
					returnMessage.setContent("时间范围不对");
				}
			}
		}

		return "success";
	}

	/**
	 * 更加场地名查找场地的周表
	 * 
	 * @return http://localhost:8080/OUMS/site/findWeekBySite
	 */
	@Action(value = "findWeekBySite", results = {
			@Result(name = "success", type = "json", params = { "root", "returnMessage" }) })
	public String findWeekBySite() {

		returnMessage = siteService.findWeekBySite(site);

		return "success";
	}

}
