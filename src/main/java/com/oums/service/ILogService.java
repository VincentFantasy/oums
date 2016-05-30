package com.oums.service;

import org.aspectj.lang.JoinPoint;

/**
 * 進入方法前和退出方法時執行日誌
 * @author 譚治
 *
 */
public interface ILogService {

	/**
	 * 前置通知
	 */
	public void beforeMethod(JoinPoint joinPoint);
	
	/**
	 * 後置通知
	 */
	public void afterMethod(JoinPoint joinPoint);
	
	/**
	 * 返回通知
	 * @param joinpoint
	 * @param result
	 */
	public void afterReturning(JoinPoint joinPoint, Object result);
	
	/**
	 * 異常通知
	 */
	public void afterThrowing(JoinPoint joinPoint, Exception e);
	
}
