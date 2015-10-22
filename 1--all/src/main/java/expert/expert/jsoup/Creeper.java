package expert.expert.jsoup;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import common.li.Config;
import common.li.FileTool;


public class Creeper {
	static Properties pro=null;
	{
		pro=Config.ini(this.getClass());
	}

	@Test
	public void testCreepercss() {  //得到 网页上的 css 
		
		String url = "http://fkgg07.faisco.cn/";
		try {
			Document d=Jsoup.parse(new File("B://work//workspace//wanmei//src//main//webapp//x.html"), "utf-8");
			Elements els= d.select("link");
			int i=0;
			for(Element el:els){
				url="http://www.chemayi.com/"+el.attr("href");
				
				i++;
				FileTool.writesStringByNIO("B://work//workspace//wanmei//src//main//webapp//css//", i+"chemayi.css", Jsoups.requerstUrl(url,"get"), "utf-8");
				el.attr("href", "./css/"+ i+"chemayi.css");
			}
			
			FileTool.writesStringByNIO("B://work//workspace//wanmei//src//main//webapp//", "cope.html", d.html(), "utf-8");
			
			//http://([a-z0-9]*\.)*xinhuanet.com/    "^([]{})([]{})([]{})$"
//			this.getDemo(s);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	@Test
	public void testCreeper() {
		String url = "http://www.chemayi.com/";
		try {
			Document d=Jsoup.parse(new File("z://work//"), "utf-8");
			Elements els= d.select("script");
			int i=0;
			for(Element el:els){
				url=el.attr("src");
				System.out.println(url);
				if(url.equals("")) continue;
				i++;
				FileTool.writesStringByNIO("B://work//workspace//wanmei//src//main//webapp//js//", i+"wanmeiyongche.js", Jsoups.requerstUrl(url,"get"), "utf-8");
				el.attr("src", "./js/"+ i+"wanmeiyongche.js");
			}
			
			FileTool.writesStringByNIO("B://work//workspace//wanmei//src//main//webapp//", "cope1.html", d.html(), "utf-8");
			
			//http://([a-z0-9]*\.)*xinhuanet.com/    "^([]{})([]{})([]{})$"
//			this.getDemo(s);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	@Test
	public void testhtml(){
		try {
			String s=Jsoups.requerstUrl("http://www.cnblogs.com/yhyjy/p/4444094.html","get");
			FileTool.writesStringByNIO("z://", "x.html", s, "utf-8");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	

	
	
	
	
	
	@Test
	public  void getzhengze()//正则表达式 提取
	{
		String str="http://sdafasdf\" sadfasdf http:// \" adsfsaf.http://0.ss.faisys.com/css/base.min.css?v=201508271604"+
			"	rel=\"stylesheet\" />"
			+"<link type=\"text/css"
			+	"href=\"http://0.ss.faisys.com/css/template/16003.min.css?v=201508241758"
			+	"rel=\"stylesheet\" id=\"templateFrame\" class=\"templateFrameClass\" />";

		String reg="^http://[^\"]*\"$";  //  \\b 边界
		//将规则封装成对象 
		Pattern p=Pattern.compile(reg);
		//让正则对象和要作用的字符串相关联起来   //获取匹配器对象
		Matcher m=p.matcher(str); 
		String s="";
		while(m.find())
		{
			s=m.group();
			System.out.println(s);
//			s=s.replaceAll("\"", "");
//			System.out.println("http://"+s);
		}
	}
	
	
	

	

}
