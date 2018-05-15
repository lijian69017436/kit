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

public class Main {

	int count = 0;

	public static void main(String[] args)  {
		// System.out.println(TestDama.string2Unicode("蒙"));
		// QY5820
		Main picc = new Main();
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
			if (PropertiesUtil.getInstance().getValue("count").equals(picc.count)) {

				return;
			}
		}
		
	}
	
	public String getValue(String str){
		return PropertiesUtil.getInstance().getValue(str);
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

		Map<String, String> cookies = getCookie();
		
		String url = "prpCrenewalVo.policyNo=&prpCrenewalVo.othFlag=&prpCrenewalVo.engineNo=&prpCrenewalVo.frameNo=&prpCrenewalVo.vinNo="
				+ "&prpCrenewalVo.licenseNo=" + chepai + "&prpCrenewalVo.licenseColorCode="
				+ "&prpCrenewalVo.licenseType=02"
				+ "&validateCodeInput=&jumpToPage=1&ipolicyNo=PDZA201711010000738358&ipolicyNo=PDAA201711010000714700";
		Document d = Jsoup.connect("http://10.134.136.48:8000/prpall/business/selectRenewal.do?pageSize=10&pageNo=1&" + url)
				.cookies(cookies).post();
		Element s = d.body();
		// System.out.println(s.text());

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

	//得到cookies 并且忽略证书验证
	private Map<String, String> getCookie() throws Exception {
		Map<String, String> cookies =  new HashMap<String, String>();
		cookies.put("JSESSIONID", PropertiesUtil.getInstance().getValue("JSESSIONID"));
		cookies.put("BOCINS_prpall_Cookie", PropertiesUtil.getInstance().getValue("BOCINS_prpall_Cookie"));
		cookies.put("BOCINS_cif_Cookie", PropertiesUtil.getInstance().getValue("BOCINS_cif_Cookie"));
		cookies.put("PICCINS_JFCD_Cookie", PropertiesUtil.getInstance().getValue("PICCINS_JFCD_Cookie"));
		SslUtils.ignoreSsl();
		return cookies;
	}

	// 查询单号
	@Test
	public void danhao() throws Exception {
		Map<String, String> cookies = getCookie();
		String operateDate = "";
		String operateDate2 = "";
		String startDate = "2016-10-01";
		String startDate2 = "2016-10-03";
		int pageNo = 1;
		while (true) {

			if (20 == pageNo) {
				return;
			}
			
			Document d = null;
			// Jsoup.parse("https://icorepnbs.pingan.com.cn/icore_pnbs/extranet_login.jsp",
			// "");
			// d=
			// Jsoup.connect("http://10.134.136.48:8000/prpall/business/editRenewalSearch.do")
			String url = ""
					+ "&comCode=11010283&riskCode=DAA&prpCproposalVo.checkFlag=&prpCproposalVo.underWriteFlag=&prpCproposalVo.strStartDate=&prpCproposalVo.othFlag=&prpCproposalVo.checkUpCode=&prpCproposalVo.operatorCode1=&prpCproposalVo.businessNature=&noNcheckFlag=0&jfcdURL=http://10.134.136.48:8100/cbc&prpallURL=http://10.134.136.48:8000/prpall&bizNoZ=&"
					+ "pageNo_=1&pageSize_=100&scmIsOpen=1111100000&searchConditionSwitch=0&queryinterval=04&electronicPolicyFlag=1&queryMenuFlag=1&prpCproposalVo.proposalNo=&prpCproposalVo.policyNo=&prpCproposalVo.licenseNo=&prpCproposalVo.vinNo=&prpCproposalVo.insuredCode=&prpCproposalVo.insuredName=&prpCproposalVo.contractNo="
					+ "&prpCproposalVo.operateDate=" + operateDate + "&prpCproposalVo.operateDate2=" + operateDate2
					+ "&prpCproposalVo.startDate=" + startDate + "&prpCproposalVo.startDate2=" + startDate2
					+ "&prpCproposalVo.underWriteFlag2=1&prpCproposalVo.underWriteFlag6=3&prpCproposalVo.underWriteFlagC=&prpCproposalVo.underWriteFlagD=D&prpCproposalVo.underWriteFlagE=E"
					+ "&prpCproposalVo.dmFlag=all&prpCproposalVo.underWriteFlagC=&prpCproposalVo.brandName=&prpCproposalVo.engineNo=&prpCproposalVo.frameNo=&prpCproposalVo.riskCode=DAA,DZA&prpCproposalVo.appliCode=&prpCproposalVo.apliName=&prpCproposalVo.makeCom=&makeComDes=&prpCproposalVo.operatorCode=&operatorCodeDes=&prpCproposalVo.comCode=&comCodeDes=&prpCproposalVo.handlerCode=&handlerCodeDes=&prpCproposalVo.handler1Code=&handler1CodeDes=&prpCproposalVo.endDate=&prpCproposalVo.endDate2=&prpCproposalVo.underWriteEndDate=&prpCproposalVo.underWriteEndDate2=";

			d = Jsoup.connect(
					"http://10.134.136.48:8000/prpall/business/selectProposal.do?pageSize=20&pageNo=" + pageNo + url)
					.cookies(cookies).timeout(1000 * 10).post();

			Element s = d.body();
			// System.out.println(s.text());

			JSONObject json = JSON.parseObject(s.text());
			// if(json.getString("totalRecords").equals("0")){
			//// System.out.println(chepai+": 无此车牌号");
			// }

			// System.out.println(json.get("totalRecords"));
			JSONArray array = json.getJSONArray("data");
			// System.out.println(array.size());
			if (0 == array.size()) {
				System.out.println("没数据了------------------------------------------");
				return;
			}

			for (int i = 0; i < array.size(); i++) {
				JSONObject o = array.getJSONObject(i);

				long ss = o.getJSONObject("startDate").getLong("time");
				String startdate = DateUtils.formateString_format(DateUtils.formatDate_ymdhms(new Date(ss)),
						"yyyy-MM-dd");

				System.out.println(startdate + "|" + o.get("licenseNo") + "|" + phone((String) o.get("proposalNo"))
						+ "|" + o.get("insuredName") + "|" + o.get("policyNo") + "|" + o.get("proposalNo"));
				;
				// long ss = o.getJSONObject("endDate").getLong("time");
				// System.out.println(DateUtils.formatDate_ymdhms(new
				// Date(ss))+"");
			}

			try {
				Thread.sleep(1000 * 3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			pageNo++;
		}

	}

	// 查询 手机号
	public String phone(String bizNo) throws Exception {
		Map<String, String> cookies = getCookie();
		
		Document d = null;
		String url = "http://10.134.136.48:8000/prpall/idcard/editIDCardCheck.do?bizNo="+bizNo;
		d = Jsoup.connect(url).cookies(cookies)
				.post();

		Element s = d.body();

		return s.select("#fm table tbody tr:eq(1) td:eq(1) input:eq(0)").val();
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
