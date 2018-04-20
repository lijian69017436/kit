package picc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
/**
 * 
 * @ClassName: DateUtils 
 * @Description: TODO(时间的 工具类) 
 * @author lijian 
 * @date 2015年12月23日 下午4:36:55 
 *
 *  yyyy-MM-dd hh:mm:ss   java时间
 *  
 */
public class DateUtils {

  /**
   * 格式化 str 为 date类型
   * yyyy-MM-dd hh:mm:ss
   * @param str  格式必须 为 yyyy-MM-dd hh:mm:ss
   * @return 
   */
  public static Date formatString_ymdhms(String str){
    SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    try {
      Date d=sim.parse(str);
      return d;
    } catch (ParseException e) {
      e.printStackTrace();
    }
    
    return null;
  }
  /**
   * 格式化  date为 字符串格式
   * @param date
   * @return
   */
  public static String formatDate_ymdhms(Date date){
    SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    return df.format(date);
  }
  
  /**
   * 格式当前时间  精确到秒
   * @return
   */
  public static int getTime_s(Date date){
    return Math.round(date.getTime()/1000); //当前 时间 格式成秒
  }
  /**
   * 格式化秒  到 时间 
   * @return
   */
  public static Date formateSS_ymdhms(int ss){
    return  new Date(ss);
  }
  
  /**
   * 格式化 日期 到  指定格式
   * @param date
   * @param format
   * @return
   */
  public static String formateString_format(String date,String format){
	  SimpleDateFormat df=new SimpleDateFormat(format);
	  return df.format(formatString_ymdhms(date));
  }
  @Test
  public void testt(){
    ;
//    String da = formateSS_ymdhms(getTime_s(new Date()));
//    System.out.println(da);
  }
}

  
