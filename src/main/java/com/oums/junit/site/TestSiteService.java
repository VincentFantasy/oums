package com.oums.junit.site;

import static org.junit.Assert.assertTrue;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.oums.bean.ReturnMessage;
import com.oums.bean.po.SitePo;
import com.oums.bean.type.SiteType;
import com.oums.bean.vo.SiteVo;
import com.oums.service.ISiteService;
import com.oums.util.BeanUtil;

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
	
	@Test
	public void test2() {
		SiteVo vo = new SiteVo();
		vo.setSiteId(123);
		vo.setSiteName("123");
		vo.setIsDelete(false);
		vo.setIsUsing(false);
		vo.setSiteCost(123f);
		vo.setSiteDtail("123");
		vo.setSiteType(1);
		SitePo po = new SitePo();
		System.out.println(vo);
		System.out.println(po);
		try {
			BeanUtils.copyProperties(po, vo);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(vo);
		System.out.println(po);
		
	}
	
	@Test
	public void test3() {
		SiteVo vo = new SiteVo();
		vo.setSiteId(123);
		vo.setSiteName("123");
		vo.setIsDelete(false);
		vo.setIsUsing(false);
		vo.setSiteCost(123f);
		vo.setSiteDtail("123");
		vo.setSiteType(1);
		SitePo po = new SitePo();
		
		BeanUtil.voToPo(po, vo);
		
		System.out.println(po);
	}
	
	@Test
	public void test4() {
		SitePo po = new SitePo();
		po.setSiteId(123);
		po.setSiteName("123");
		po.setIsDelete(false);
		po.setIsUsing(false);
		po.setSiteCost(123f);
		po.setSiteDtail("123");
		po.setSiteType(1);
		SiteVo vo = new SiteVo();
		
		BeanUtil.poToVo(vo, po);
		
		System.out.println(vo);
	}
}
