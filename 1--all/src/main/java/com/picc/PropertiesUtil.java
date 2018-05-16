package com.picc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
	private static final String CONFIG_FILE = "Z:\\work\\git\\kit\\1--base\\src\\main\\java\\picc\\config.properties"; //打成jar包 时候运行需要
//	/1--base/src/main/java/picc/config.properties
	private PropertiesUtil() {
		 Locale locale = Locale.getDefault();  
//		rb = ResourceBundle.getBundle(CONFIG_FILE,locale);
		
		properties  = new Properties();
	     // 使用InPutStream流读取properties文件
	     try {
	    	BufferedReader bufferedReader = new BufferedReader(new FileReader(CONFIG_FILE));
			properties.load(bufferedReader);
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
	
	/**
	 * 获取本地回调接口URL
	 * @return
	 */
	public static String getRequestPayResultURL(){
		return getInstance().getValue("requestPayResultURL");
	}
	public static String getBuyGoldHandleURL(){
		return getInstance().getValue("buyGoldHandleURL");
	}
	public static String getAbsGoldHandleURL(){
		return getInstance().getValue("AbsGoldHandleURL");
	}
	public static String getSellGoldHandleURL(){
		return getInstance().getValue("SellGoldHandleURL");
	}
	
	/**
	 * 健康卡激活URL
	 * @return
	 */
	public static String getHealthactivaction(){
		return getInstance().getValue("healthactivaction");
	}
	/**
	 * 健康卡查询URL
	 * @return
	 */
	public static String getHealthquery(){
		return getInstance().getValue("healthquery");
	}
	/**
	 * 获取客服电话
	 * @return
	 */
	public static String getTel(){
		return getInstance().getValue("tel");
	}
	/**
	 * 获取工作日时间
	 * @return
	 */
	public static String getWorkSpace(){
		return getInstance().getValue("workSpace");
	}
	
}
