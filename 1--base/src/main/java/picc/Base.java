package picc;

import java.util.HashMap;
import java.util.Map;

import picc.common.PropertiesUtil;
import picc.common.SslUtils;

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
	
	//得到 开始时间
	protected String getStartTime(){
		PropertiesUtil ins = PropertiesUtil.getInstance();
		return ins.getValue("yy")+"-"+ins.getValue("mm")+"-"+ins.getValue("dd1");
	}
	//得到 结束时间
	protected String getEndTime(){
		PropertiesUtil ins = PropertiesUtil.getInstance();
		return ins.getValue("yy")+"-"+ins.getValue("mm")+"-"+ins.getValue("dd2");
	}
	//得到文件名
	protected String getExcelName(){
		PropertiesUtil ins = PropertiesUtil.getInstance();
		return ins.getValue("yy")+ins.getValue("mm")+"_"+ins.getValue("user")+".xls";
	}
	
	
	
}
