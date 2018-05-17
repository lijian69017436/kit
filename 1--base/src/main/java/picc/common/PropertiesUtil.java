package picc.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;


public class PropertiesUtil {
	private static Object lock              = new Object();
	private static PropertiesUtil config     = null;
	private static ResourceBundle rb        = null;
	
	
	static Properties properties;
//	private static final String CONFIG_FILE = "picc/config"; //eclipse环境下运行
//	private static final String CONFIG_FILE = "config"; //打成jar包 时候运行需要
//	private static final String CONFIG_FILE = "z:\\work\\git\\kit\\1--base\\src\\main\\java\\picc\\config.properties"; //打成jar包 时候运行需要
//	private static final String CONFIG_FILE = "d:\\lijian\\config.properties"; //打成jar包 时候运行需要
//	/1--base/src/main/java/picc/config.properties
	private PropertiesUtil() {
		 Locale locale = Locale.getDefault();  
//		rb = ResourceBundle.getBundle(CONFIG_FILE,locale);
		
		properties  = new Properties();
	     // 使用InPutStream流读取properties文件
	     try {
	    	 
		    File file=null;
		    InputStream is=null;
//		     Properties prop=new Properties();
		    file=new File("config.properties");
		     is=new FileInputStream(file);
		     properties.load(is);
	    		     
//	    	BufferedReader bufferedReader = new BufferedReader(new FileReader(CONFIG_FILE));
//			properties.load(bufferedReader);
		} catch (IOException e) {
			e.printStackTrace();
		}
//	     // 获取key对应的value值
//	     properties.getProperty(String key);
	}
	
	    
	
	public static PropertiesUtil getInstance() {
		synchronized(lock) {
			if(null == config) {
				config = new PropertiesUtil();
			}
		}
		return (config);
	}
	
	public String getValue(String key) {
		return (properties.getProperty(key));
	}
	
	
}
