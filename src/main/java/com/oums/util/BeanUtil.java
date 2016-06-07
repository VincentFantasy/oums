package com.oums.util;


import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import com.oums.bean.po.BasePo;
import com.oums.bean.vo.BaseVo;

/**
 * Bean装换工具，注意null值也会复制过去
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
			BeanUtils.copyProperties(vo, po, getNullPropertyNames(vo));
			logger.info("转换成功");
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
			BeanUtils.copyProperties(po, vo, getNullPropertyNames(po));
			logger.info("转换成功");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		
		logger.info("退出voToPo方法");
	}
	
	/**
	 * 提前处理空属性
	 * @param source
	 * @return
	 */
	public static String[] getNullPropertyNames (Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<String>();
        for(java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
	
}
