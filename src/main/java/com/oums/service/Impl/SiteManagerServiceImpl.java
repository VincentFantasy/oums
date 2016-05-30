package com.oums.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oums.bean.ReturnMessage;
import com.oums.bean.po.SitePo;
import com.oums.bean.vo.SiteVo;
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
			po.setIsUsing(false);
			po.setIsDelete(false);
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
			vo.setIsUsing(po.getIsUsing());
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
			returnMessage.setContent("异常");
		}
		
		return returnMessage;
	}

}
