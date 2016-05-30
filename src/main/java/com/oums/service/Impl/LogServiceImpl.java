package com.oums.service.Impl;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

import com.oums.service.ILogService;

@Component("logService")
public class LogServiceImpl implements ILogService {

	Logger logger = LogManager.getLogger();
	
	@Override
	public void beforeMethod(JoinPoint joinPoint) {
		if(joinPoint == null) {
			return;
		}
		
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());

		logger.info("The method begins " + methodName + " begins with " + args);
	}

	@Override
	public void afterMethod(JoinPoint joinPoint) {
		if(joinPoint == null) {
			return;
		}
		
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		
		logger.info("The method after " + methodName + " after with " + args);
	}

	@Override
	public void afterThrowing(JoinPoint joinPoint, Exception e) {
		if(joinPoint == null) {
			return;
		}
		
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());

		logger.error("The method " + methodName + " occurs excetion with : " + e);
	}

	@Override
	public void afterReturning(JoinPoint joinPoint, Object result) {
		String methodName = joinPoint.getSignature().getName();
		
		logger.info("The method " + methodName + " ends with " + result);
	}

}
