package picc;

import java.util.HashMap;
import java.util.Map;

public class Base {

	
	//得到cookies 并且忽略证书验证
	protected Map<String, String> getCookie() throws Exception {
		Map<String, String> cookies =  new HashMap<String, String>();
		cookies.put("JSESSIONID", PropertiesUtil.getInstance().getValue("JSESSIONID"));
		cookies.put("BOCINS_prpall_Cookie", PropertiesUtil.getInstance().getValue("BOCINS_prpall_Cookie"));
		cookies.put("BOCINS_cif_Cookie", PropertiesUtil.getInstance().getValue("BOCINS_cif_Cookie"));
		cookies.put("PICCINS_JFCD_Cookie", PropertiesUtil.getInstance().getValue("PICCINS_JFCD_Cookie"));
		SslUtils.ignoreSsl();
		return cookies;
	}
	
	
	protected String getValue(String str){
		return PropertiesUtil.getInstance().getValue(str);
	}
}
