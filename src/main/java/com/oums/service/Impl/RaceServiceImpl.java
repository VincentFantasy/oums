package com.oums.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oums.bean.ReturnMessage;
import com.oums.bean.po.RacePo;
import com.oums.bean.vo.RaceVo;
import com.oums.dao.IRaceDao;
import com.oums.service.IRaceService;

@Service("raceService")
public class RaceServiceImpl implements IRaceService {

	@Autowired
	IRaceDao raceDao;
	
	@Override
	public ReturnMessage findRaceByName(RaceVo vo) {
		ReturnMessage returnMessage = new ReturnMessage();
		
		try{
			RacePo po = raceDao.findRackByName(vo.getRaceName());
			
			if(po == null)
				throw new NullPointerException();
				
			returnMessage.setFlat(true);
			returnMessage.setContent("查找成功");
			returnMessage.setObject(po);
		} catch (NullPointerException e) {
			returnMessage.setFlat(false);
			returnMessage.setContent("没有这个名字的赛事");
		} catch (Exception e) {
			e.printStackTrace();
			returnMessage.setFlat(false);
			returnMessage.setContent("操作异常");
		}
		
		return returnMessage;
	}

	@Override
	public ReturnMessage findRaceLikeName(RaceVo vo) {
		ReturnMessage returnMessage = new ReturnMessage();
		
		try{
			List<RacePo> poList = raceDao.findRaceLikeName(vo.getRaceName());
			
			returnMessage.setFlat(true);
			returnMessage.setContent("查找成功");
			returnMessage.setObject(poList);
		} catch (NullPointerException e) {
			returnMessage.setFlat(false);
			returnMessage.setContent("没有这个名字的赛事");
		} catch (Exception e) {
			e.printStackTrace();
			returnMessage.setFlat(false);
			returnMessage.setContent("操作异常");
		}
		
		return returnMessage;
	}

}
