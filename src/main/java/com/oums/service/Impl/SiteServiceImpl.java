package com.oums.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oums.bean.ReturnMessage;
import com.oums.bean.po.SitePo;
import com.oums.bean.vo.SiteVo;
import com.oums.dao.IBaseDao;
import com.oums.service.ISiteService;

@Service("siteService")
public class SiteServiceImpl implements ISiteService {	
	
	@Autowired
	IBaseDao baseDao;
	
	@Override
	public ReturnMessage addSite(SiteVo vo) {
		ReturnMessage returnMessage = new ReturnMessage();
		
		try{
			SitePo po = new SitePo();
			//SiteName需要查重
			po.setSiteName(vo.getSiteName());
			po.setSiteType(vo.getSiteType());
			po.setSiteCost(vo.getSiteCost());
			po.setSiteDtail(vo.getSiteDtail());
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReturnMessage updateSite(SiteVo vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReturnMessage findSiteByName(String siteName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReturnMessage updataSiteUsingByName(String siteName) {
		// TODO Auto-generated method stub
		return null;
	}

}
