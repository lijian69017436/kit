package common.li;

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
 