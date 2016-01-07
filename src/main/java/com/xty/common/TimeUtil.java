package com.xty.common;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
	public static Timestamp getToday() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dt = new Date();
		try {
			Timestamp today = new Timestamp(sdf.parse(sdf.format(dt))
					.getTime());
			return today;
		} catch (ParseException e) {
			throw new RuntimeException("日期格式化或者解析错误"); // should never be here
		}
	}

	public static Timestamp getDay(Timestamp timestamp) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dt = (Date) timestamp;
		try {
			Timestamp day = new Timestamp(sdf.parse(sdf.format(dt))
					.getTime());
			return day;
		} catch (ParseException e) {
			throw new RuntimeException("日期格式化或者解析错误"); // should never be here
		}
	}

	public static Timestamp addDays(Timestamp timestamp, int n) {
		return new Timestamp(timestamp.getTime() + n * 24 * 60 * 60 * 1000L);
	}
}
