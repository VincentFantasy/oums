package com.oums.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oums.bean.ReturnMessage;
import com.oums.bean.po.DayPo;
import com.oums.bean.po.SitePo;
import com.oums.bean.po.WeekPo;
import com.oums.bean.type.ItemState;
import com.oums.bean.vo.DayVo;
import com.oums.bean.vo.SiteVo;
import com.oums.bean.vo.WeekVo;
import com.oums.dao.IBaseDao;
import com.oums.dao.ISiteDao;
import com.oums.service.ISiteManagerService;
import com.oums.util.BeanUtil;

@Service("siteManagerService")
public class SiteManagerServiceImpl implements ISiteManagerService {

	@Autowired
	IBaseDao baseDao;
	
	@Autowired
	ISiteDao siteDao;
	
	@Override
	public ReturnMessage addSite(SiteVo vo) {
		ReturnMessage returnMessage = new ReturnMessage();
		
		try{
			//SiteName需要查重
			SitePo po = new SitePo();		
			BeanUtil.voToPo(vo, po);
			//設置某些屬性為false
			WeekPo week = new WeekPo(ItemState.FREE);
			po.setIsDelete(false);
			po.setWeek(week);
			baseDao.add(po);
			
			returnMessage.setFlat(true);
			returnMessage.setContent("添加场地成功");
		} catch (Exception e) {
			e.printStackTrace();
			returnMessage.setFlat(false);
			returnMessage.setContent("异常");
		}
		
		return returnMessage;
	}

	@Override
	public ReturnMessage deleteSite(SiteVo vo) {
		ReturnMessage returnMessage = new ReturnMessage();
		
		try{
			SitePo po = siteDao.findSitePoBySiteName(vo.getSiteName());	
			//不是真的删除
			po.setIsDelete(true);
			
			baseDao.update(po);
			
			returnMessage.setFlat(true);
			returnMessage.setContent("添加场地成功");
		} catch(NullPointerException e) {
			e.printStackTrace();
			returnMessage.setFlat(false);
			returnMessage.setContent("没有此场地或场地已删除");
		} catch (Exception e) {
			e.printStackTrace();
			returnMessage.setFlat(false);
			returnMessage.setContent("异常");
		}
		
		return returnMessage;
	}

	@Override
	public ReturnMessage updateSite(SiteVo vo) {
		ReturnMessage returnMessage = new ReturnMessage();
		
		try{			
			//获取到po,vo的id要为null
			SitePo po = siteDao.findSitePoBySiteName(vo.getSiteName());
			vo.setSiteId(po.getSiteId());
			vo.setIsDelete(po.getIsDelete());
			BeanUtil.voToPo(vo, po);
			
			baseDao.update(po);
			
			returnMessage.setFlat(true);
			returnMessage.setContent("添加场地成功");
		} catch(NullPointerException e) {
			e.printStackTrace();
			returnMessage.setFlat(false);
			returnMessage.setContent("没有此场地或场地已删除");
		} catch(IllegalArgumentException e) {
			e.printStackTrace();
			returnMessage.setFlat(false);
			returnMessage.setContent("没有此场地或场地已删除");
		} catch (Exception e) {
			e.printStackTrace();
			returnMessage.setFlat(false);
			returnMessage.setContent("更新异常");
		}
		
		return returnMessage;
	}

	@Override
	public ReturnMessage updateSiteType(SiteVo vo, WeekVo weekVo, DayVo dayVo) {
		ReturnMessage returnMessage = new ReturnMessage();
		
		try{
			SitePo po = siteDao.findSitePoBySiteName(vo.getSiteName());
			WeekPo weekPo = po.getWeek();
			DayPo dayPo = null;
			
			switch (dayVo.getDayOfWeek()) {
			case 0:
				dayPo = weekPo.getSunday();
				break;			
			case 1:
				dayPo = weekPo.getMonday();
				break;			
			case 2:
				dayPo = weekPo.getTuesday();
				break;			
			case 3:
				dayPo = weekPo.getWednesday();
				break;			
			case 4:
				dayPo = weekPo.getThurday();
				break;
			case 5:
				dayPo = weekPo.getFriday();
				break;
			case 6:
				dayPo = weekPo.getSaturday();
				break;
			default:
				throw new NullPointerException();
			}
			
			BeanUtil.voToPo(dayVo, dayPo);
			System.out.println(dayPo);
			baseDao.update(dayPo);
			
			returnMessage.setFlat(true);
			returnMessage.setContent("操作成功");
			
		} catch(NullPointerException e) {
			e.printStackTrace();
			returnMessage.setFlat(false);
			returnMessage.setContent("没有此场地");
		} catch (Exception e) {
			e.printStackTrace();
			returnMessage.setFlat(false);
			returnMessage.setContent("更新异常");
		}
		
		return returnMessage;
	}

}
