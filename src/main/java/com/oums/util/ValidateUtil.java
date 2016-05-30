package com.oums.util;

import java.util.regex.Pattern;

/**
 * 校验工具,现在需要的暂时这样直接用
 * 迟点弄个注解校验，方便
 * @author 谭治
 *
 */
public class ValidateUtil {

	/* 纯数字 */
	public final static String VALIDATE_NUMBER = "[0-9]+$";
	
	private static Pattern pattern = null;
	
	/**
	 * 校验纯数字的字符串
	 * @param num
	 * @return
	 */
	public static Boolean stringIsNum(String num) {
		pattern = Pattern.compile(VALIDATE_NUMBER);
		return pattern.matcher(num).matches();
	}
	
	/**
	 * 校验自定义的匹配规则的字符串
	 * @param num
	 * @param patternRule
	 * @return
	 */
	public static Boolean stringIsRule(String str, String patternRule) {
		try{
			pattern = Pattern.compile(patternRule);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return pattern.matcher(str).matches();
	}
	
}
