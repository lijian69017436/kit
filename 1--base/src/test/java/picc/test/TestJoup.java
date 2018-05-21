package picc.test;

import java.io.File;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

public class TestJoup {

	@Test
	public void t1() {
		try {
			
			File in = new File("C:/Users/Administrator/Desktop/1.html");
			Document doc = Jsoup.parse(in, "gbk", ""); 
			;
			System.out.println(doc.select("input[id^='showIdentifyNumber']").val());
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}
