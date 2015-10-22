package common.li;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 初始化配置文件类
 * @author Administrator
 *
 */
public class Config {

	/**
	  * 初始化  config.ini 配置文件
	  * 
	  * @param config 为当前配置文件同目录的 类
	  * @return Properties
	  */
	  public static Properties ini(Class<?> config)  {
	    File file=null;
	    InputStream is=null;
	    Properties prop=new Properties();
	    Log.debug(config.toString()+"-");
	    try {
	      file=new File(config.getResource("").toURI().getPath()+ "config.ini");   //同目录的 路径
	      Log.debug("配置文件路径"+file.getCanonicalPath());
	      is=new FileInputStream(file);
	      prop.load(is);
	    } catch (Exception e) {
	      e.printStackTrace();
	    }finally{
	      if(is!=null) {
	        try {
	          is.close();
	        } catch (IOException e) {
	          e.printStackTrace();
	        }
	      }
	    }  
	    return prop;
	  }
	  /**
	   * 无参数 为classpath 跟下的配置文件
	   * @return
	   */
	  public static Properties ini()  {
		    File file=null;
		    InputStream is=null;
		    Properties prop=new Properties();
		    try {
		      file=new File(Config.class.getResource("/").toURI().getPath()+ "config.ini");   
		      Log.debug("配置文件路径"+file.getCanonicalPath());
		      is=new FileInputStream(file);
		      prop.load(is);
		    } catch (Exception e) {
		      e.printStackTrace();
		    }finally{
		      if(is!=null) {
		        try {
		          is.close();
		        } catch (IOException e) {
		          e.printStackTrace();
		        }
		      }
		    }  
		    return prop;
	  }
}
