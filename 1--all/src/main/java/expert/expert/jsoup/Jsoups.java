package expert.expert.jsoup;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import common.li.Config;
import common.li.FileTool;
import common.li.Log;


/**
 * jsoup 自定义
 * @author Administrator
 *
 */
public class Jsoups {
	static Properties pro=null;
	{
		pro=Config.ini(this.getClass());
	}
	/**
	 * 
	 * @param url 网页路径
	 * @param json json 参数
	 * @param method request 方式
	 * @return
	 * @throws IOException
	 */
	public static String requerstUrl(String url,String json,String method) throws IOException{
		Connection  doc = Jsoup.connect(url)
				.ignoreContentType(true)
				.timeout(100000);
		if(json!=null){
			doc.data("data",json);
		}
		if(method.equals("get")){
			doc.method(Method.GET);
		}else{
			doc.method(Method.POST);
		}
	    Response rep=	doc.execute();
		return rep.body();
	}
	
	/**
	 *  
	 * @param url 
	 * @param method request方式
	 * @return
	 * @throws IOException
	 */
	public static String requerstUrl(String url,String method) throws IOException{
		Connection  doc = Jsoup.connect(url)
				.ignoreContentType(true)
				.timeout(100000);
		if(method.equals("get")){
			doc.method(Method.GET);
		}else{
			doc.method(Method.POST);
		}
	    Response rep=	doc.execute();
		return rep.body();
	}
	@Test
	public void dd(){
		String s="http:...";
		s=s.substring(0, 4);
		Log.debug(s);
	}
	public static void creeperHtml() throws IOException{
		String url = pro.getProperty("url");
		String cssname=pro.getProperty("cssname");
		String jsname=pro.getProperty("jsname");
		String rooturl=pro.getProperty("rooturl");

		String htmlfile = pro.getProperty("htmlfile");
		String htmlname = pro.getProperty("htmlname");

		Document doc=Jsoup.parse(Jsoups.requerstUrl(url,"get"), "utf-8");
		Elements els= doc.select("link");
		int i=0;
		for(Element el:els){
			url =el.attr("href").substring(0, 4);
			if(url.equals("")) continue;
			if(!url.equals("http")){
				url=rooturl+el.attr("href");
			}else{
				url=el.attr("href");
			}
			
			FileTool.writesStringByNIO(htmlfile+"css//",cssname+i+".css", Jsoups.requerstUrl(url,"get"), "utf-8");
			el.attr("href", "./css/"+cssname+i+".css");
			i++;
		}
		i=0;
		els= doc.select("script");
		for(Element el:els){
			url=el.attr("src").substring(0, 4);
			if(url.equals("")) continue;
			if(!url.equals("http")){
				url=rooturl+el.attr("href");
			}else{
				url=el.attr("href");
			}
			FileTool.writesStringByNIO(htmlfile+"js//", jsname+i+".js", Jsoups.requerstUrl(url,"get"), "utf-8");
			el.attr("src", "./js/"+jsname+i+".js");
			i++;
		}
		
		FileTool.writesStringByNIO(htmlfile,htmlname+".html", doc.html(), "utf-8");
	}
}
