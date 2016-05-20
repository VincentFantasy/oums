package com.oums.junit.site;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.oums.bean.ReturnMessage;
import com.oums.bean.type.SiteType;
import com.oums.bean.vo.SiteVo;
import com.oums.service.ISiteService;

public class TestSiteService {

	@Autowired
	ISiteService siteService;
	
	@Test
	public void test() {
		SiteVo vo = new SiteVo();
		vo.setSiteName("球場1");
		vo.setSiteType(SiteType.SITETYPE_BADMINTON);
		vo.setSiteCost(10.0f);
		vo.setSiteDtail("詳細");
		ReturnMessage returnMessage = siteService.addSite(vo);
		
		assertTrue(returnMessage.isFlat());
	}

}
