package common.li;

import java.util.ResourceBundle;

/**
 * 得到  properties 配置文件 
 * @author Administrator
 *
 */
public class Configuration {
	

	private static Object lock              = new Object();
	private static Configuration config     = null;
	private static ResourceBundle rb        = null;
	private static final String CONFIG_FILE = "merchantInfo";
	
	private Configuration() {
		rb = ResourceBundle.getBundle(CONFIG_FILE);
	}
	
	public static Configuration getInstance() {//单例 创建对象
		synchronized(lock) {
			if(null == config) {
				config = new Configuration();
			}
		}
		return (config);
	}
	
	public String getValue(String key) {//根据对象得到  属性
		return (rb.getString(key));
	}
}
/*
 * Confguration.getInstance.getValue("payNeedSmsURL");  //调用方法
 * 可以根据 key 得到 value
 * 
 * */

/*
merchantInfo.properties       文件名

文件 内容
#
#4.2.1 发送短验-支付请求地址
payNeedSmsURL=https://ok.yeepay.com/payapi/api/tzt/pay/bind/reuqest
#
#4.2.2 发送短信验证码接口请求地址
smsSendURL=https://ok.yeepay.com/payapi/api/tzt/pay/validatecode/send
#
#4.2.3 确认支付请求地址
smsConfirmURL=https://ok.yeepay.com/payapi/api/tzt/pay/confirm/validatecode
#



*/