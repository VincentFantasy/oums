package com.oums.junit.util;

import static org.junit.Assert.*;

import org.junit.Test;

import com.oums.bean.po.SitePo;
import com.oums.bean.vo.SiteVo;
import com.oums.util.BeanUtil;
import com.oums.util.OrderUtil;

public class TestBeanUtil {

	@Test
	public void testCopyNullP() {
		SiteVo vo = new SiteVo();
		SitePo po = new SitePo();
		vo.setSiteName("123");
		po.setSiteCost(1f);
		BeanUtil.voToPo(vo, po);
		System.out.println(po);
	}
	
	@Test
	public void testCopyNullV() {
		SiteVo vo = new SiteVo();
		SitePo po = new SitePo();
		po.setSiteName("123");
		vo.setSiteCost(1f);
		BeanUtil.poToVo(po, vo);
		System.out.println(vo);
	}

}
