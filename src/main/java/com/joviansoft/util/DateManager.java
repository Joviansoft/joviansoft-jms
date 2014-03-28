package com.joviansoft.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class DateManager {
	
	public static final String SHORT_TIME_FOTMAT = "yyyyMMdd";
	public static final String LONG_TIME_FOTMAT = "yyyyMMddHHmmss";
	public static final String VERY_SHORT_TIME_FORMAT = "yyyyMM";
	public static final String OTHER_FORMAT = "yyyy-MM-dd HH:mm:ss";
	
	public static String getServerTime(String flag) throws Exception{
		if(flag.equals("short")){
			flag = SHORT_TIME_FOTMAT;
		}else if(flag.equals("long")){
			flag = LONG_TIME_FOTMAT;
		}else if(flag.equals("veryshort")){
			flag = VERY_SHORT_TIME_FORMAT;
		}
		Calendar cd = Calendar.getInstance();
	    SimpleDateFormat fmt = new SimpleDateFormat(flag);
	    return fmt.format(cd.getTime());
	}
	
	public static String getHalfYearAgoTime()  throws Exception{
		Calendar cd = Calendar.getInstance();
		cd.add(Calendar.DATE, -180);
		SimpleDateFormat fmt = new SimpleDateFormat(SHORT_TIME_FOTMAT);
		return fmt.format(cd.getTime());
	}
	
	public static String getChineseYMD(){
		Calendar rightNow = Calendar.getInstance();
		return rightNow.get(Calendar.YEAR)+"年"+new Integer(rightNow.get(Calendar.MONTH)+1)+"月"+rightNow.get(Calendar.DAY_OF_MONTH)+"日";
	}
	
	public static String getDateAgoByParam(int day){
		Calendar cd = Calendar.getInstance();
		cd.add(Calendar.DATE, -day);
		SimpleDateFormat fmt = new SimpleDateFormat(SHORT_TIME_FOTMAT);
		return fmt.format(cd.getTime());
	}
	
	public static String getDateAfterByParam(int day){
		Calendar cd = Calendar.getInstance();
		cd.add(Calendar.DATE, day);
		SimpleDateFormat fmt = new SimpleDateFormat(SHORT_TIME_FOTMAT);
		return fmt.format(cd.getTime());
	}
	
	
	
	// 用来全局控制 上一周，本周，下一周的周数变化
    private static int weeks = 0;
   
    // 获得当前日期与本周一相差的天数
    private static int getMondayPlus() {
        Calendar cd = Calendar.getInstance();
        // 获得今天是一周的第几天，星期日是第一天，星期二是第二天......
        int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek == 1) {
            return -6;
        } else {
            return 2 - dayOfWeek;
        }
    }

    // 获得上周星期一的日期
    public static String getPreviousMonday() {
        weeks--;
        int mondayPlus = getMondayPlus();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, mondayPlus + 7 * weeks);
        Date monday = currentDate.getTime();
//      DateFormat df = DateFormat.getDateInstance();
      DateFormat df = getFormat();
        String preMonday = df.format(monday);
        return preMonday;
    }

    // 获得本周星期一的日期
    public static String getCurrentMonday() {
        weeks = 0;
        int mondayPlus = getMondayPlus();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, mondayPlus);
        Date monday = currentDate.getTime();
//      DateFormat df = DateFormat.getDateInstance();
      DateFormat df = getFormat();
        String preMonday = df.format(monday);
        return preMonday;
    }

    // 获得下周星期一的日期
    public static String getNextMonday() {
        weeks++;
        int mondayPlus = getMondayPlus();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, mondayPlus + 7 * weeks);
        Date monday = currentDate.getTime();
//      DateFormat df = DateFormat.getDateInstance();
      DateFormat df = getFormat();
        String preMonday = df.format(monday);
        return preMonday;
    }

    // 获得相应周的周日的日期
    public static String getSunday() {
        int mondayPlus = getMondayPlus();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, mondayPlus + 7 * weeks + 6);
        Date monday = currentDate.getTime();
//        DateFormat df = DateFormat.getDateInstance();
        DateFormat df = getFormat();
        String preMonday = df.format(monday);
        return preMonday;
    }
    
    public static SimpleDateFormat getFormat(){
    	return new SimpleDateFormat("yyyyMMdd");
    }
    
//    public static String getMonthFirstDay(){
//    	Date d = new Date();
//		int m = d.getMonth();
//		int y = d.getYear();
//		Date firstDay = new Date(y,m+1,1) ;
//		Date from = new Date(y,m,1);
//		DateFormat df = new TestA().getFormat();
//		return df.format(from);
//    }
//    
//    public static String getMonthLastDay(){
//    	Date d = new Date();
//		int m = d.getMonth();
//		int y = d.getYear();
//		Date firstDay = new Date(y,m+1,1) ;
//		int min = 24*60*60*1000;
//		Date from = new Date(y,m,1);
//		Date to = new Date(firstDay.getTime()-min);
//		DateFormat df = new TestA().getFormat();
//		return df.format(to);
//    }
//    
    /**
     * 
     * @param pretime 前面时间 （减掉时间）
     * @param nexttime 下一时间（被减时间） 
     * @param format 时间格式 "long-长时间 "short"短时间 
     * @return 时间差 
     * @throws Exception
     */
    public static long getTimePlus(String pretime,String nexttime,String format) throws Exception{
    	DateFormat df = new SimpleDateFormat(format);
    	Date d1 = df.parse(pretime);
    	Date d2 = df.parse(nexttime);
    	long diff = d2.getTime() - d1.getTime();
    	long days = diff / (1000 * 60 * 60 * 24);
    	return days;
    }
	
    /**
	 * 
	 * @Title: getFormatString
	 * @Description: TODO
	 * @param @param time
	 * @param @param format1
	 * @param @param format2
	 * @param @return
	 * @return String
	 * @throws
	 */
	public static String convertDateStringFormat(String time, String format1,
			String format2) {
		String str = "";
		if (time != null && !time.equals("")) {
			java.text.DateFormat df1 = new java.text.SimpleDateFormat(format1);
			try {
				Date date1 = df1.parse(time);
				DateFormat df2 = new SimpleDateFormat(format2);
				str = df2.format(date1);

			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return str;
	}
	
	public static long getTimePlusInMilliseconds(String time1, String time2, String format) throws ParseException{
		DateFormat df = new SimpleDateFormat(format);
    	Date d1 = df.parse(time1);
    	Date d2 = df.parse(time2);
    	return d2.getTime() - d1.getTime();
	}
}	
