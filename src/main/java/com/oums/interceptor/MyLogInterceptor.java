package com.oums.interceptor;

import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.oums.bean.ReturnMessage;

/**
 * 日志拦截器，不用在Action前后加log4j2类记录了
 * @author 谭治
 *
 */
public class MyLogInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 1L;
	
	/* 加载logger */
	private static Logger logger;

	@Override
	public void init() {
		super.init();
		logger = LogManager.getLogger(MyLogInterceptor.class.getName());
		logger.info("MyLogInterceptor初始化");
	}
	
	@Override
	public void destroy() {
		super.destroy();
		logger.info("MyLogInterceptor销毁");
	}

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		
		logger.info("进入" + arg0.getProxy().getMethod());
		
		String result = arg0.invoke();
		
		//这样取出returnMessage影响响应时间？ 看看有没性能更高的方法
		Object message = null;
		for(Method method : arg0.getAction().getClass().getDeclaredMethods()) {
			if(ReturnMessage.class.isAssignableFrom(method.getReturnType())) {
				message = method.invoke(arg0.getAction());
				break;
			}
		}
		
		logger.info("退出" + arg0.getProxy().getMethod() + "  returnMessage:" + message);
		
		//结束拦截器
		return result;
		
	}

}
