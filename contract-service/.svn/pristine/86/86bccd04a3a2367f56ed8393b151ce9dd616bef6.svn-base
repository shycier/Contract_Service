package com.jzt56.jlp.contractservice.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	public static final String YEARTOSECOND = "yyyy-MM-dd HH:mm:ss";
	public static final String YEARTODATE = "yyyy-MM-dd";
	public static final String HOURTOSECOND = "HH:mm:ss";
	
	public static String format(Date date) {
		if(null != date) {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(YEARTOSECOND);	 
			return simpleDateFormat.format(date);
		}
		return null;
	}
	
	public static String format(Date date,String formate) {
		if(null != date) {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formate);	 
			return simpleDateFormat.format(date);
		}
		return null;
	}
	
	public static Date parse(String source) throws ParseException {
		if(null != source) {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(YEARTOSECOND);	 
			return simpleDateFormat.parse(source);
		}
		return null;
	}
	
	public static Date parse(String source,String formate) throws ParseException {
		if(null != source) {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formate);	 
			return simpleDateFormat.parse(source);
		}
		return null;
	}
	
}
