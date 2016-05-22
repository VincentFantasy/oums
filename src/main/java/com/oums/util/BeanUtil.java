package com.oums.util;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.oums.bean.po.BasePo;
import com.oums.bean.vo.BaseVo;

/**
 * Bean装换工具
 * @author 谭治
 *
 */
public class BeanUtil {

	private static Logger logger = LogManager.getLogger(BeanUtil.class.getName()); 
	
	/**
	 * vo的属性赋值到po，要求属性名称一样
	 * @param t
	 * @param x
	 */
	public static <T extends BaseVo, X extends BasePo> void voToPo(T vo, X po) {
		logger.info("进入voToPo方法");
		
		try {
			BeanUtils.copyProperties(po, vo);
			logger.info("转换成功");
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			logger.error(e);
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			logger.error(e);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		
		logger.info("退出voToPo方法");
	}
	
	/**
	 * po的属性赋值到vo，要求属性名称一样
	 * @param t
	 * @param x
	 */
	public static <T extends BasePo, X extends BaseVo> void poToVo(T po, X vo) {
		logger.info("进入voToPo方法");
		
		try {
			BeanUtils.copyProperties(vo, po);
			logger.info("转换成功");
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			logger.error(e);
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			logger.error(e);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		
		logger.info("退出voToPo方法");
	}
	
}
