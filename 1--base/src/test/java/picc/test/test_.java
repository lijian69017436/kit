package picc.test;

import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;

import picc.Base;

public class test_ extends Base{

	

	@Test //查询  客户详情信息时候   报错
	public void ddd() {
		String st="http://10.134.136.48:8300/cif/customperson/prepareUpdate.do?"
				+ "customerCode=1100100002687586"
				+ "&syscode=prpall";
		Element s=null;
		try {
		
			Document d = null;
			
			Connection con = Jsoup.connect(st)
					.cookies(getCookie())
					.timeout(1000 * 40);
			con.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");  
			con.header("Accept-Encoding", "gzip, deflate, sdch");  
			con.header("Accept-Language", "zh-CN,zh;q=0.8");  
			con.header("User-Agent", "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.3; WOW64; Trident/7.0; .NET4.0E; .NET4.0C; Tablet PC 2.0; InfoPath.2; .NET CLR 3.5.30729; .NET CLR 2.0.50727; .NET CLR 3.0.30729)"); 
			
			d = con.post();

			s = d.body();
			System.out.println(s.html());
		} catch (Exception e) {
			e.printStackTrace();
			
			// TODO: handle exception
		}
		
		String sd="http://10.134.136.48:8000/prpall/multicast/multicastPage.do?"
				+ "toUrl=/prpall/business/browseProposal.do?bizNo="
				+ "&bizNos=TDAA201811010001918422";
	}
	
	@Test //这个能查到  身份证的具体地址  性别等...
	public void dddf() {
		String st="http://10.134.136.48:8000/prpall/business/quickProposalEditRenewalCopy.do?bizNo=PDZA201711010000738358";
		Element s=null;
		try {
			
			Document d = null;
			
			Connection con = Jsoup.connect(st)
					.cookies(getCookie())
					.timeout(1000 * 40);
			con.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");  
			con.header("Accept-Encoding", "gzip, deflate, sdch");  
			con.header("Accept-Language", "zh-CN,zh;q=0.8");  
			con.header("User-Agent", "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.3; WOW64; Trident/7.0; .NET4.0E; .NET4.0C; Tablet PC 2.0; InfoPath.2; .NET CLR 3.5.30729; .NET CLR 2.0.50727; .NET CLR 3.0.30729)"); 
			
			d = con.post();
			
			s = d.body();
			System.out.println(s.html());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
