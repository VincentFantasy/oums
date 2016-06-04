package com.oums.util;

import java.util.Calendar;

/**
 * 订单的一些工具
 * @author 谭治
 *
 */
public class OrderUtil {

	/**
	 * 生成订单号 年月日时分秒加4位随机数共18位订单号
	 * @return
	 */
	public static String createOrderNumber() {
		//获取当前时间
		Calendar c = Calendar.getInstance();		
		int numbers[] = {c.get(Calendar.YEAR), c.get(Calendar.MONTH) + 1, c.get(Calendar.DATE), c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE), c.get(Calendar.SECOND)};
		//拼接字符串
		StringBuffer number = new StringBuffer();		
		for(int i : numbers)
			if(i < 10)
				number.append("0" + i);
			else
				number.append(i);		
		number.append(createRandomNumber());
			
		return number.toString();		
	}
	
	/**
	 * 生成4位数据数
	 * @return
	 */
	private static int createRandomNumber() {
		int num = (int) (Math.random() * 9000 + 1000);
		return num;
	}
	
}
