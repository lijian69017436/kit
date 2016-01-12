package common.li;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {
	
	//得到近三天的日期数组;
	public static String[] getDateArray()
	{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date date=new Date();
		String curDate=sdf.format(date);
		date=new Date(date.getTime()-1000*60*60*24);
		String yesDate=sdf.format(date);
		date=new Date(date.getTime()-1000*60*60*24);
		String qianDate=sdf.format(date);
		
		return new String[]{curDate,yesDate,qianDate};
	}
	
	
	/**
	 * 字符串转换到时间格式
	 * @param dateStr 需要转换的字符串
	 * @param formatStr 需要格式的目标字符串  举例 yyyy-MM-dd
	 * @return Date 返回转换后的时间
	 * @throws ParseException 转换异常
	 */
	public static Date StringToDate(String dateStr,String formatStr){
		DateFormat sdf=new SimpleDateFormat(formatStr);
		Date date=null;
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * 计算两个日期差     注意格式要一致
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static long getDay(Date startDate,Date endDate){
		Calendar calendar1 = Calendar.getInstance();
  	    Calendar calendar2 = Calendar.getInstance();
  	    calendar1.setTime(startDate);
  	    calendar2.setTime(endDate);
   	    long milliseconds1 = calendar1.getTimeInMillis();
   	    long milliseconds2 = calendar2.getTimeInMillis();
   	    long diff = milliseconds2 - milliseconds1;
//   	    long diffSeconds = diff / 1000;      
//   	    long diffMinutes = diff / (60 * 1000);
//   	    long diffHours = diff / (60 * 60 * 1000);
   	    long diffDays = diff / (24 * 60 * 60 * 1000);
   	    return diffDays;
	}
	
	
	/**
	 * 将日期加几天
	 * @param date
	 * @param value
	 * @return
	 */
	
	public static Date addDay(Date date,int value){
	 Calendar   calendar   =   new   GregorianCalendar(); 
     calendar.setTime(date); 
     calendar.add(calendar.DATE,value);//把日期往后增加一天.整数往后推,负数往前移动 
     date=calendar.getTime(); 
     return date;
	} 
	
	
	public static String dateToString(Date date ,String formatStr){
		DateFormat sdf=new SimpleDateFormat(formatStr);
		return sdf.format(date);
	}
	public static Date dateFormat(Date date ,String formatStr){
		DateFormat sdf=new SimpleDateFormat(formatStr);
		String s =  sdf.format(date);
		try {
			date = sdf.parse(s);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	public static String Time() {
		  Calendar c = Calendar.getInstance();
		  c.setTimeInMillis(System.currentTimeMillis());
		  java.util.Date d = c.getTime();
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		  return sdf.format(d);
	}
	
	
//日期转换
  public static String formartDate(String datetype) {
    String TIME_LONG = "yyyy-MM-dd HH:mm:ss";
    String TIME_SHORT = "yyyy-MM-dd";
    String TIME_SHORTER = "yyyy-MM-dd HH:mm";

    SimpleDateFormat formart = null;
    if (datetype == "Long") {
      formart = new SimpleDateFormat(TIME_LONG);
    } else if (datetype == "Short") {
      formart = new SimpleDateFormat(TIME_SHORT);
    } else if (datetype == "Shorter") {
      formart = new SimpleDateFormat(TIME_SHORTER);
    } else {
      formart = new SimpleDateFormat(TIME_LONG);
    }
    String dateStr = formart.format(new Date());
    return dateStr;
  }
}