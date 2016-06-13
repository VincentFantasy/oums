package com.oums.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.oums.bean.po.DayPo;
import com.oums.bean.po.SitePo;
import com.oums.bean.po.WeekPo;
import com.oums.bean.vo.DayVo;

/**
 * 时间工具
 * @author 谭治
 *
 */
public class TimeUtil {

	/**
	 * 返回今天是星期几
	 * @return
	 */
	public static int dayOfWeek() {
		Calendar rightNow = Calendar.getInstance();
		int day = rightNow.get(Calendar.DAY_OF_WEEK) - 1;
		return day;
	}
	
	/**
	 * 获取当前时间
	 * @return
	 */
	public static Date getNowTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = sdf.parse(sdf.format(new Date()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * 改变场地的周期表状态
	 * @param sitePo
	 * @param day
	 * @param time
	 * @param itemState
	 * @param reitemState 原来状态为这个就才返回true
	 */
	public static boolean changeSiteDayOfWeekState(SitePo sitePo, int day, int time, int itemState, int reItemState) {
		int timeInDay = -1;
		DayPo dayPo = null;
		WeekPo weekPo = sitePo.getWeek();
		
		//选择出星期
		switch (day) {
		case 0:
			dayPo = weekPo.getSunday();
			break;
		case 1:
			dayPo = weekPo.getMonday();
			break;
		case 2:
			dayPo = weekPo.getTuesday();
			break;
		case 3:
			dayPo = weekPo.getWednesday();
			break;
		case 4:
			dayPo = weekPo.getThurday();
			break;
		case 5:
			dayPo = weekPo.getFriday();
			break;
		case 6:
			dayPo = weekPo.getSaturday();
			break;
		default:
			break;
		}
		
		switch (time) {
		case 0:
			timeInDay = dayPo.getTime0();
			dayPo.setTime0(itemState);
			break;
		case 1:
			timeInDay = dayPo.getTime1();
			dayPo.setTime1(itemState);
			break;
		case 2:
			timeInDay = dayPo.getTime2();
			dayPo.setTime2(itemState);
			break;
		case 3:
			timeInDay = dayPo.getTime3();
			dayPo.setTime3(itemState);
			break;
		case 4:
			timeInDay = dayPo.getTime4();
			dayPo.setTime4(itemState);
			break;
		case 5:
			timeInDay = dayPo.getTime5();
			dayPo.setTime5(itemState);
			break;

		default:
			break;
		}
		
		if(timeInDay == reItemState)
			return true;
		else
			return false;
	}
	
	public static void setDayVoTime(DayVo vo, int timeInDay, int itemType) {
		switch (timeInDay) {
		case 0:
			vo.setTime0(itemType);
			break;
		
		case 1:
			vo.setTime1(itemType);
			break;
			
		case 2:
			vo.setTime2(itemType);
			break;

		case 3:
			vo.setTime3(itemType);
			break;
			
		case 4:
			vo.setTime4(itemType);
			break;
			
		case 5:
			vo.setTime5(itemType);
			break;
		
		default:
			break;
		}
	}
	
}
