package common.li;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log {
  /** 记录日志的对象. */
  public static Logger  base=LoggerFactory.getLogger("base");
  
  
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
 