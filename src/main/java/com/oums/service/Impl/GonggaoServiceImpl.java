package com.oums.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oums.bean.ReturnMessage;
import com.oums.bean.po.GonggaoPo;
import com.oums.bean.vo.GonggaoVo;
import com.oums.dao.IBaseDao;
import com.oums.dao.IGonggaoDao;
import com.oums.service.IGonggaoService;
import com.oums.util.BeanUtil;
import com.oums.util.TimeUtil;


@Service("gonggaoService")
public class GonggaoServiceImpl implements IGonggaoService {

	@Autowired
	IBaseDao baseDao;

	@Autowired
	IGonggaoDao gonggaoDao;

	@Override
	public ReturnMessage addGonggao(GonggaoVo vo) {
		ReturnMessage returnMessage = new ReturnMessage();
		
		try{
			GonggaoPo po = new GonggaoPo();
			BeanUtil.voToPo(vo, po);
			po.setBuildTime(TimeUtil.getNowTime());
			po.setIsDelete(false);

			baseDao.add(po);
			
			returnMessage.setFlat(true);
			returnMessage.setContent("操作成功");			 
		} catch (Exception e) {
			e.printStackTrace();
			returnMessage.setFlat(false);
			returnMessage.setContent("操作异常");
		}
		
		return returnMessage;
	}

	@Override
	public ReturnMessage deleteGonggao(GonggaoVo vo) {
		ReturnMessage returnMessage = new ReturnMessage();
		
		try{
			GonggaoPo po = baseDao.findById(GonggaoPo.class, vo.getGonggaoId());
			po.setIsDelete(true);
			baseDao.update(po);
			
			returnMessage.setFlat(true);
			returnMessage.setContent("删除成功");			 
		} catch (Exception e) {
			e.printStackTrace();
			returnMessage.setFlat(false);
			returnMessage.setContent("操作异常");
		}
		
		return returnMessage;
	}

	@Override
	public ReturnMessage findGonggaoById(GonggaoVo vo) {
		ReturnMessage returnMessage = new ReturnMessage();
		
		try{
			GonggaoPo po = baseDao.findById(GonggaoPo.class, vo.getGonggaoId());

			returnMessage.setObject(po);
			returnMessage.setFlat(true);
			returnMessage.setContent("查找成功");			 
		} catch (Exception e) {
			e.printStackTrace();
			returnMessage.setFlat(false);
			returnMessage.setContent("查找失败" + e);
		}
		
		return returnMessage;
	}

	@Override
	public ReturnMessage getAllGonggao() {
		ReturnMessage returnMessage = new ReturnMessage();
		
		try{
			List<GonggaoPo> list = gonggaoDao.getAllGonggao();

			returnMessage.setObject(list);
			returnMessage.setFlat(true);
			returnMessage.setContent("查找成功");			 
		} catch (Exception e) {
			e.printStackTrace();
			returnMessage.setFlat(false);
			returnMessage.setContent("查找失败" + e);
		}
		
		return returnMessage;
	}

}
