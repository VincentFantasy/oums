package com.oums.util;

import java.util.Calendar;

/**
 * 
 * @author fantasy
 *
 */
public class TimeUtil {

	public static int dayOfWeek() {
		Calendar rightNow = Calendar.getInstance();
		int day = rightNow.get(Calendar.DAY_OF_WEEK) - 1;
		return day;
	}
	
}
