package com.oums.junit.race;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.oums.bean.ReturnMessage;
import com.oums.bean.po.RacePo;
import com.oums.bean.vo.RaceVo;
import com.oums.junit.BaseUnit;
import com.oums.service.IRaceService;

public class TestFindRace extends BaseUnit{

	@Autowired
	IRaceService raceService;
	
	@Test
	public void testfindRaceByName() {
		//测试存在的数据
		RaceVo raceVo = new RaceVo();
		raceVo.setRaceName("123");
		
		ReturnMessage returnMessage = raceService.findRaceByName(raceVo);
		
		if(returnMessage.isFlat()){
			assertTrue(true);
			System.out.println((RacePo)returnMessage.getObject());
		}
		
		//测试不存在的数据
		raceVo.setRaceName("124");
		
		if(!returnMessage.isFlat()){
			assertTrue(true);
		}
	}
	
	@Test
	public void testfindRaceLikeName() {
		//测试存在的数据
		RaceVo raceVo = new RaceVo();
		raceVo.setRaceName("123");
		
		ReturnMessage returnMessage = raceService.findRaceLikeName(raceVo);
		
		if(returnMessage.isFlat()){
			assertTrue(true);
			System.out.println(returnMessage.getObject());
		}
		
//		raceVo.setRaceName("1");
//		
//		returnMessage = raceService.findRaceByName(raceVo);
//		
//		if(returnMessage.isFlat()){
//			assertTrue(true);
//			System.out.println(returnMessage.getObject());
//		}
//		
//		raceVo.setRaceName("3");
//		
//		returnMessage = raceService.findRaceByName(raceVo);
//		
//		if(returnMessage.isFlat()){
//			assertTrue(true);
//			System.out.println(returnMessage.getObject());
//		}
//		
//		//测试不存在的数据
//		raceVo.setRaceName("4");
//		
//		if(!returnMessage.isFlat()){
//			assertTrue(true);
//		}
	}
	
}
