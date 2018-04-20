package com.ejz.wechat.util;

import java.util.ResourceBundle;


public class PropertiesUtil {
	private static Object lock              = new Object();
	private static PropertiesUtil config     = null;
	private static ResourceBundle rb        = null;
	private static final String CONFIG_FILE = "properties/config";
	
	private PropertiesUtil() {
		rb = ResourceBundle.getBundle(CONFIG_FILE);
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
		return (rb.getString(key));
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
