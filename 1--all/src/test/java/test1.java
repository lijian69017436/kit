import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.junit.Test;

import common.li.Log;

public class test1 {
	@Test
	public void test2() {
		Log.debug("-----");
		HashMap<Object, Object> map = new HashMap<>();
		map.put("123", "213");
		map.put("1233", "213");
		System.out.println(map.toString());
		String i = "123123";
		System.out.println(i.length());
		Log.info(String.format("你好:%s%s", 1 << 4, "--"));
	}

	@Test
	public void test3() {
		try {
			Log.debug("-----");
			
			
			//传入年
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date o=sdf.parse("2014-07-30");
			
			System.out.println(new Date().getYear());
			System.out.println(o.getYear()+1900);
			
			
			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
