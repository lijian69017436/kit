package common.li.util;

import java.util.ResourceBundle;

public class ConfigPro {
	

	private static Object lock              = new Object();
	private static ConfigPro config     = null;
	private static ResourceBundle rb        = null;
	private static final String CONFIG_FILE = "merchantInfo";
	
	private ConfigPro() {
		rb = ResourceBundle.getBundle(CONFIG_FILE);
	}
	
	public static ConfigPro getInstance() {
		synchronized(lock) {
			if(null == config) {
				config = new ConfigPro();
			}
		}
		return (config);
	}
	
	public String getValue(String key) {
		return (rb.getString(key));
	}
}