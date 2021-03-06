package picc;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import picc.common.DateUtils;

public class Main extends Base{

	int count = 0;

	//根据 车牌子查 
	public static void main(String[] args)  {
		// System.out.println(TestDama.string2Unicode("蒙"));
		// QY5820
		Main picc = new Main();
//		Log.debug("-----");
		System.out.println("总共需要执行的次数  : "+picc.getValue("count"));

		// 随机1w个车牌
		for (int i = 0; i < 100000; i++) {
			String chepai = "%BE%A9";// %BE%A9 = 京
			if (i % 2 == 0) {
				chepai += "Q";
			} else {
				chepai += "N";
			}
			chepai += picc.randomchepai();
			// System.out.println("车牌号是："+chepai);
			try {
				picc.dd(chepai);
			} catch (Exception e) {
				e.printStackTrace();
				continue;
				// TODO: handle exception
			}
			// System.out.println(i);
			// Thread.sleep(30);
			System.out.println("执行请求数据总数:"+picc.count);
			if (picc.getValue("count").equals(picc.count)) {

				return;
			}
		}
		
	}
	

	/**
	 * 随机车牌
	 * 
	 * @return
	 */
	private String randomchepai() {
		int count = 0;
		String carNo = "";
		while (count < 5) {
			long time = System.currentTimeMillis();
			Random random = new Random(time);
			String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			char str2 = str.charAt(random.nextInt(26));
			int num = random.nextInt(10);
			// 字母与数字的概率相同
			if (num < 5) {
				carNo += num;
			} else {
				carNo += str2;
			}
			count++;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		return carNo;
	}

	/**
	 * 请求人保数据
	 * 
	 * @param chepai
	 * @throws Exception
	 */
	public void dd(String chepai) throws Exception {
		System.out.println("1");
		Map<String, String> cookies = getCookie();
		
		String url = "prpCrenewalVo.policyNo=&prpCrenewalVo.othFlag=&prpCrenewalVo.engineNo=&prpCrenewalVo.frameNo=&prpCrenewalVo.vinNo="
				+ "&prpCrenewalVo.licenseNo=" + chepai + "&prpCrenewalVo.licenseColorCode="
				+ "&prpCrenewalVo.licenseType=02"
				+ "&validateCodeInput=&jumpToPage=1&ipolicyNo=PDZA201711010000738358&ipolicyNo=PDAA201711010000714700";
		Document d = Jsoup.connect("http://10.134.136.48:8000/prpall/business/selectRenewal.do?pageSize=10&pageNo=1&" + url)
				.cookies(cookies).post();
		Element s = d.body();
		 System.out.println(s.text());

		System.out.println("2");
		JSONObject json = JSON.parseObject(s.text());
		if (json.getString("totalRecords").equals("0")) {
			// System.out.println(chepai+": 无此车牌号");
			return;
		}
		JSONArray array = json.getJSONArray("data");

		for (int i = 0; i < array.size(); i++) {
			count++;
			JSONObject o = array.getJSONObject(array.size() - 1);
			long ss = o.getJSONObject("endDate").getLong("time");
			System.out.println(o.get("licenseNo") + "  " + DateUtils.formatDate_ymdhms(new Date(ss)) + "");
			return;
		}

	}






	
	@Test
	public void d() throws IOException{
		for(int i=1;i<100;i++){
			
		//45  10分钟不够
			
		String url= "https://sojump.com/handler/processjq.ashx?curid=16018239&starttime=2017%2F8%2F24%209%3A28%3A08&source=directphone&submittype=1&rn=1022712535.40799416&t=1503538162650";
		//url+="&submitdata=1$地方}2$2}3$1}4$3}5$1}6$2}7$2}8$4}9$1}10$1<1,2<1,3<1,4<1,5<1,6<1}11$1}12$2}13$2}14$2}15$4}16$2}17$4}18$2}19$1}20$2}21$2}22$2}23$1}24$5}25$2}26$地方";
		Map<String, String> cookies = new HashMap<String, String>();
		cookies.put("UM_distinctid", "15e11da9d8c289-0916cfcf6677b4-6316157a-100200-15e11da9d8d251");
		cookies.put("ASPXANONYMOUS", "LOSoFApT0wEkAAAANDI5NjgxMjYtNmYwZC00ZjVlLTgzM2YtNDY4YWYyMTdmNzliv-Ru-uvlllnRdbdBks4mKbpCxik1");
		cookies.put("CNZZDATA4478442", "cnzz_eid%3D2105914366-1503536190-%26ntime%3D1503536190");
		cookies.put("jac16018239", "40799416");
		Document d = Jsoup.connect(url)
				.data("submitdata","1$地方}2$2}3$1}4$3}5$1}6$2}7$2}8$4}9$1}10$1<1,2<1,3<1,4<1,5<1,6<1}11$1}12$2}13$2}14$2}15$4}16$2}17$4}18$2}19$1}20$2}21$2}22$2}23$1}24$5}25$2}26$地方")
				.post();
		System.out.println(d.body());
		try {
			Thread.sleep(1000 * 1);
			if(i%4==0){
				Thread.sleep(1000 * 60 * 30);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
	}
	
	
}
