package exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/*
 *   周日：7  2014-08-10
 *   周2：为现在日期的星期 2014-08-05
 * 
 *   下周一： 2014-08-10  +  i=1; 
 *    ...  +   i++;
 *    
 *    上周五：2014-08-10  -7  求上周日；-2 周五； +  j=-7-2
 *    ...  +  j--
 *    
 * 
 * */

public class DateUtils {
	//求当前日期距离本周日相差几天；
   public long getDateBetweenOfWeek(Date day){
	   Calendar calendar=Calendar.getInstance(); //得到日历
	   calendar.setTime(day); //设置时间 
	   //calendar.set(2014, 7,10);
	   int date=calendar.get(Calendar.DAY_OF_WEEK);//1-7 //得到 周 几
	   switch (date) {
			case 1://周日
				  date=7;
				break;
			case 2://周一
				  date=1;
				break;
			case 3:
				  date=2;
				break;
			case 4:
				  date=3;
				break;
			case 5:
				  date=4;
				break;
			case 6:
				  date=5;
			case 7://周六
				  date=6;
				break;	
	 
	   }
	   
	   return 7-date;
  }
   
   //指定日期的所在周 周日，日期；
   public Date getSundayDay(Date day){
	   Calendar calendar=Calendar.getInstance();
	   calendar.setTime(day);
	   calendar.add(Calendar.DAY_OF_MONTH, (int)this.getDateBetweenOfWeek(day));
	   Date date=calendar.getTime();
	   return date;
   }
   
   
   
   //该方法用于获取下周一到周五日期：
   public String [] getNextWeekDays(Date day){
	  Date sunday= this.getSundayDay(day);//获取本周日日期；
	  Calendar calendar=Calendar.getInstance();//获取calendar对象，操作date
	  calendar.setTime(sunday);//将本周日日期，转为Calendar对象；
	  int i=1;
	  String nextWeekDaysStr[]=new String[5];
	  SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
	  calendar.add(Calendar.DAY_OF_MONTH, i);//周一
	  	nextWeekDaysStr[0]=format.format(calendar.getTime());
	  	
	  calendar.add(Calendar.DAY_OF_MONTH, i);//周二
	  	nextWeekDaysStr[1]=format.format(calendar.getTime());
	  	
	  calendar.add(Calendar.DAY_OF_MONTH, i);//周三
	  	nextWeekDaysStr[2]=format.format(calendar.getTime());
	  	
	  calendar.add(Calendar.DAY_OF_MONTH, i);//周四
	  	nextWeekDaysStr[3]=format.format(calendar.getTime());
	  	
	  calendar.add(Calendar.DAY_OF_MONTH, i);//周五
	  	nextWeekDaysStr[4]=format.format(calendar.getTime());
	   
	   return nextWeekDaysStr;
   }
   
   //获取指定日期上一周，周一到周五日期；
   public String[] getLastWeekdays(Date day){
	   Calendar calendar=Calendar.getInstance();
	   Date sunday=this.getSundayDay(day);
	   calendar.setTime(sunday);
	   int j=-7-2;
	   String [] items=new String[5];
	   SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
	   calendar.add(Calendar.DAY_OF_MONTH, j);//上周五
	      	items[4]=format.format(calendar.getTime());
	      
	   calendar.add(Calendar.DAY_OF_MONTH, -1);//上周四
	       	items[3]=format.format(calendar.getTime());
	   
	   calendar.add(Calendar.DAY_OF_MONTH, -1);//上周三
	   		items[2]=format.format(calendar.getTime());
	   
	   calendar.add(Calendar.DAY_OF_MONTH, -1);//上周二
			items[1]=format.format(calendar.getTime());
		
	   calendar.add(Calendar.DAY_OF_MONTH, -1);//上周一
			items[0]=format.format(calendar.getTime());
	   
	   return items;
   }
   
   
    public static void main(String args[]) throws ParseException{
      DateUtils date_between=new DateUtils();
      Date day=new Date();
      SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
      String now="2014-08-07";
      day=format.parse(now);
      long j= date_between.getDateBetweenOfWeek(day);//获取指定日期距离该日期所在周的周日，天数差；
     
      System.out.println("指定日期距离该日期周日天数："+j);
      
      Date day_sunday= date_between.getSundayDay(day);//获取指定日期所在周日，日期；
     
      
     System.out.println("指定日期为："+format.format(day_sunday));
     
     //查看下周周一到周五日期：
    String [] items_nextweek= date_between.getNextWeekDays(day);
     for(int i=0;i<items_nextweek.length;i++){
    	 System.out.println("下周日期："+items_nextweek[i]);
     }
     
     System.out.println("*********************");
     
     //查看上周周一到周五日期：
     String [] items_lastweek= date_between.getLastWeekdays(day);
      for(int i=0;i<items_lastweek.length;i++){
     	 System.out.println("上周日期："+items_lastweek[i]);
      }
     
   } 
    
}
