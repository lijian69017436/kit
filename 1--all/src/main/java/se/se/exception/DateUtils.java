package se.se.exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/*
 *   ���գ�7  2014-08-10
 *   ��2��Ϊ�������ڵ����� 2014-08-05
 * 
 *   ����һ�� 2014-08-10  +  i=1; 
 *    ...  +   i++;
 *    
 *    �����壺2014-08-10  -7  �������գ�-2 ���壻 +  j=-7-2
 *    ...  +  j--
 *    
 * 
 * */

public class DateUtils {
	//��ǰ���ھ��뱾�������죻
   public long getDateBetweenOfWeek(Date day){
	   Calendar calendar=Calendar.getInstance(); //�õ�����
	   calendar.setTime(day); //����ʱ�� 
	   //calendar.set(2014, 7,10);
	   int date=calendar.get(Calendar.DAY_OF_WEEK);//1-7 //�õ� �� ��
	   switch (date) {
			case 1://����
				  date=7;
				break;
			case 2://��һ
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
			case 7://����
				  date=6;
				break;	
	 
	   }
	   
	   return 7-date;
  }
   
   //ָ�����ڵ������� ���գ����ڣ�
   public Date getSundayDay(Date day){
	   Calendar calendar=Calendar.getInstance();
	   calendar.setTime(day);
	   calendar.add(Calendar.DAY_OF_MONTH, (int)this.getDateBetweenOfWeek(day));
	   Date date=calendar.getTime();
	   return date;
   }
   
   
   
   //�÷������ڻ�ȡ����һ���������ڣ�
   public String [] getNextWeekDays(Date day){
	  Date sunday= this.getSundayDay(day);//��ȡ���������ڣ�
	  Calendar calendar=Calendar.getInstance();//��ȡcalendar���󣬲���date
	  calendar.setTime(sunday);//�����������ڣ�תΪCalendar����
	  int i=1;
	  String nextWeekDaysStr[]=new String[5];
	  SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
	  calendar.add(Calendar.DAY_OF_MONTH, i);//��һ
	  	nextWeekDaysStr[0]=format.format(calendar.getTime());
	  	
	  calendar.add(Calendar.DAY_OF_MONTH, i);//�ܶ�
	  	nextWeekDaysStr[1]=format.format(calendar.getTime());
	  	
	  calendar.add(Calendar.DAY_OF_MONTH, i);//����
	  	nextWeekDaysStr[2]=format.format(calendar.getTime());
	  	
	  calendar.add(Calendar.DAY_OF_MONTH, i);//����
	  	nextWeekDaysStr[3]=format.format(calendar.getTime());
	  	
	  calendar.add(Calendar.DAY_OF_MONTH, i);//����
	  	nextWeekDaysStr[4]=format.format(calendar.getTime());
	   
	   return nextWeekDaysStr;
   }
   
   //��ȡָ��������һ�ܣ���һ���������ڣ�
   public String[] getLastWeekdays(Date day){
	   Calendar calendar=Calendar.getInstance();
	   Date sunday=this.getSundayDay(day);
	   calendar.setTime(sunday);
	   int j=-7-2;
	   String [] items=new String[5];
	   SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
	   calendar.add(Calendar.DAY_OF_MONTH, j);//������
	      	items[4]=format.format(calendar.getTime());
	      
	   calendar.add(Calendar.DAY_OF_MONTH, -1);//������
	       	items[3]=format.format(calendar.getTime());
	   
	   calendar.add(Calendar.DAY_OF_MONTH, -1);//������
	   		items[2]=format.format(calendar.getTime());
	   
	   calendar.add(Calendar.DAY_OF_MONTH, -1);//���ܶ�
			items[1]=format.format(calendar.getTime());
		
	   calendar.add(Calendar.DAY_OF_MONTH, -1);//����һ
			items[0]=format.format(calendar.getTime());
	   
	   return items;
   }
   
   
    public static void main(String args[]) throws ParseException{
      DateUtils date_between=new DateUtils();
      Date day=new Date();
      SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
      String now="2014-08-07";
      day=format.parse(now);
      long j= date_between.getDateBetweenOfWeek(day);//��ȡָ�����ھ�������������ܵ����գ�����
     
      System.out.println("ָ�����ھ����������������"+j);
      
      Date day_sunday= date_between.getSundayDay(day);//��ȡָ�������������գ����ڣ�
     
      
     System.out.println("ָ������Ϊ��"+format.format(day_sunday));
     
     //�鿴������һ���������ڣ�
    String [] items_nextweek= date_between.getNextWeekDays(day);
     for(int i=0;i<items_nextweek.length;i++){
    	 System.out.println("�������ڣ�"+items_nextweek[i]);
     }
     
     System.out.println("*********************");
     
     //�鿴������һ���������ڣ�
     String [] items_lastweek= date_between.getLastWeekdays(day);
      for(int i=0;i<items_lastweek.length;i++){
     	 System.out.println("�������ڣ�"+items_lastweek[i]);
      }
     
   } 
    
}
