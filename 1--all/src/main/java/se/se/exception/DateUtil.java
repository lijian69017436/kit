package se.se.exception;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
  public long getDateBetweenOfWeek(Date day) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(day);
    // calendar.set(2014, 7,10);
    int date = calendar.get(Calendar.DAY_OF_WEEK);// 1-7
    switch (date) {
      case 1:
        date = 7;
        break;
      case 2:
        date = 1;
        break;
      case 3:
        date = 2;
        break;
      case 4:
        date = 3;
        break;
      case 5:
        date = 4;
        break;
      case 6:
        date = 5;
      case 7:// 
        date = 6;
        break;
    }

    return 7 - date;
  }

  public Date getSundayDay(Date day) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(day);
    calendar.add(Calendar.DAY_OF_MONTH, (int) this.getDateBetweenOfWeek(day));
    Date date = calendar.getTime();
    return date;
  }

  public String[] getNextWeekDays(Date day) {
    Date sunday = this.getSundayDay(day);
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(sunday);
    int i = 1;
    String nextWeekDaysStr[] = new String[5];
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    calendar.add(Calendar.DAY_OF_MONTH, i);
    nextWeekDaysStr[0] = format.format(calendar.getTime());

    calendar.add(Calendar.DAY_OF_MONTH, i);
    nextWeekDaysStr[1] = format.format(calendar.getTime());

    calendar.add(Calendar.DAY_OF_MONTH, i);
    nextWeekDaysStr[2] = format.format(calendar.getTime());

    calendar.add(Calendar.DAY_OF_MONTH, i);
    nextWeekDaysStr[3] = format.format(calendar.getTime());

    calendar.add(Calendar.DAY_OF_MONTH, i);
    nextWeekDaysStr[4] = format.format(calendar.getTime());

    return nextWeekDaysStr;
  }

  public String[] getLastWeekdays(Date day) {
    Calendar calendar = Calendar.getInstance();
    Date sunday = this.getSundayDay(day);
    calendar.setTime(sunday);
    int j = -7 - 2;
    String[] items = new String[5];
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    calendar.add(Calendar.DAY_OF_MONTH, j);// ������
    items[4] = format.format(calendar.getTime());

    calendar.add(Calendar.DAY_OF_MONTH, -1);// ������
    items[3] = format.format(calendar.getTime());

    calendar.add(Calendar.DAY_OF_MONTH, -1);// ������
    items[2] = format.format(calendar.getTime());

    calendar.add(Calendar.DAY_OF_MONTH, -1);// ���ܶ�
    items[1] = format.format(calendar.getTime());

    calendar.add(Calendar.DAY_OF_MONTH, -1);// ����һ
    items[0] = format.format(calendar.getTime());

    return items;
  }

  public static void main(String args[]) throws ParseException {
    DateUtil date_between = new DateUtil();
    Date day = new Date();
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    String now = "2014-08-07";
    day = format.parse(now);
    long j = date_between.getDateBetweenOfWeek(day);

    System.out.println("----" + j);

    Date day_sunday = date_between.getSundayDay(day);

    System.out.println("--------" + format.format(day_sunday));

    String[] items_nextweek = date_between.getNextWeekDays(day);
    for (int i = 0; i < items_nextweek.length; i++){
      System.out.println("" + items_nextweek[i]);
    }

    System.out.println("*********************");

    String[] items_lastweek = date_between.getLastWeekdays(day);
    for (int i = 0; i < items_lastweek.length; i++){
      System.out.println("" + items_lastweek[i]);
    }

  }

}
