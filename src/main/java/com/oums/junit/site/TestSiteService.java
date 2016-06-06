package com.oums.junit.site;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.oums.bean.vo.SiteVo;
import com.oums.junit.BaseUnit;
import com.oums.service.ISiteManagerService;
import com.oums.service.ISiteService;

public class TestSiteService extends BaseUnit{

	@Autowired
	ISiteService siteService;
	
	@Autowired
	ISiteManagerService siteManagerService;
	
	SiteVo site;
	
	@Before
	public void beforeTest1(){
		site = new SiteVo();
		site.setSiteName("111");
	}
	
	@Test
	public void test1() {

			assertTrue(siteService != null);
			
		siteManagerService.addSite(site);	
	}
}
