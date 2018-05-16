package picc;

import org.apache.log4j.Logger;

public class Log {
  /** 记录日志的对象. */
  public static Logger  base=Logger.getLogger("base");
  
  
  public static void debug(String line){
	  base.debug(line);
  }
  public static void debug(String line,Object... arg){
    base.debug(String.format(line,arg));
  }
  
  public static void info(String line){
	  base.info(line);
  }
  
  public static void error(String line){
	  base.error(line);
  }
  
}
//Logger.getLogger("base");   这是 取 出 loger 名称
//Logger.getLogger(Log.class);  这是 更灵活的  一种方式  这种 可配置性 超高  
//这样写  是 按照 包 打印       lijian包
//log4j.logger.lijian=debug, Console,baseLog
//这样写   是 独立出  rootlog
//log4j.additivity.lijian=false
//log4j.appender.baseLog=org.apache.log4j.DailyRollingFileAppender
//log4j.appender.DatePattern='.'yyyy-MM-dd
//log4j.appender.baseLog.File=${catalina.base}/logs/lijian.log
//log4j.appender.baseLog.layout=org.apache.log4j.PatternLayout
//log4j.appender.baseLog.layout.ConversionPattern=%d %-5p  %-50m  ## %l  [%t] %n

