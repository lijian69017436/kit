package picc;

import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class Phone extends Base {

	// 
	/**
	 * 
	 * @Description: TODO(用一句话描述该文件做什么)  
	 * @author 李健   
	 * @param IdentifyNumber //身份证号
	 * @return
	 */
	public String  getPhone(String IdentifyNumber) {
		try {
			Thread.sleep(1000 * 1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Document d = null;
		Element s = null;
		// 根据身份证 抓取 手机号
		String dd = "http://10.134.136.48:8000/prpall/custom/customAmountQueryP.do" 
				+ "?_identifyType=01"
				+ "&_insuredName=" 
				+ "&_identifyNumber="+ IdentifyNumber 
				+ "&_insuredCode=" 
				+ "&time=1526615123879";

		try {
			d = Jsoup.connect(dd).
					cookies(getCookie())
					.timeout(1000 * 10)
					.post();
			s = d.body();
			// "showIdentifyNumber[0]";
			// System.out.println(d.body());
			// 身份证
			// String IdentifyNumber =s.select("#insertInsuredRow tbody tr:eq(1) td:eq(5)
			// input:eq(1)").val();
			// System.out.println(s.html());
			JSONObject json = (JSONObject) JSONObject.parse(s.html());
			JSONArray jsonArray = json.getJSONArray("data");
			JSONObject j = (JSONObject) jsonArray.get(0);
			// System.out.println("手机号:"+j.get("mobileNoYG"));
			return j.getString("mobileNoYG");
			// ("#insertInsuredRow input:eq(0) ").val());
			// System.out.println(s.select("#insertInsuredRow
			// input[name^=showIdentifyNumber*] ").html());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";

	}

	// 身份采集 的时候 查询 手机号
	// 2018-05-19 日测试时,已经不好使了
	@Deprecated
	public String getPhone(String bizNo, String deprecated) {

		Element s = null;
		Element ss = null;
		try {
			String sss = "http://10.134.136.48:8000/prpall/business/showCinsured.do" + "?systemCode="
					+ "&editType=SHOW_POLICY" + "&bizType=POLICY" + "&bizNo=" + bizNo + "&riskCode=DAA&minusFlag="
					+ "&contractNo=" + "&comCode=11010283" + "&originQuery=" + "&beiRenewalFlag="
					+ "&proposalNo=TDAA201711010001891870" + "&rnd822=Wed May 16 18:22:55 UTC+0800 2018";
			// /business/showCinsured.do
			Map<String, String> cookies = getCookie();
			// Thread.sleep(1000 * 1);
			Document d = null;
			String url = "http://10.134.136.48:8000/prpall/idcard/editIDCardCheck.do?bizNo=" + bizNo;
			d = Jsoup.connect(url).cookies(cookies).post();
			s = d.body();
			// System.out.println("查询手机号返回结果:"+s);
			// String url =
			// "http://10.134.136.48:8000/prpall/idcard/editIDCardCheck.do?bizNo="+bizNo;
			Document ht = Jsoup.connect(sss).cookies(cookies).post();
			ss = ht.body();
			// System.out.println("查询关系人信息返回结果:"+ss);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s.select("#fm table tbody tr:eq(1) td:eq(1) input:eq(0)").val();
	}
}
