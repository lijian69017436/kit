package picc;

import java.util.Date;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import picc.common.DateUtils;
import picc.common.Log;

public class DanHao extends Base{

	public static void main(String[] args) {
		new DanHao().danhao();
	}
	

	// 查询单号 
	@Test
	public void danhao()  {
		String operateDate = "";
		String operateDate2 = "";
		String startDate = getValue("startTime");
		String startDate2 = getValue("endTime");
		System.out.println("时间:"+startDate);
		System.out.println("时间:"+startDate2);
		int pageNo = 1;
		while (true) {
			if (20 == pageNo) {
				return;
			}
			Document d = null;
			Connection con=null;
			// Jsoup.parse("https://icorepnbs.pingan.com.cn/icore_pnbs/extranet_login.jsp",
			// "");
			// d=
			// Jsoup.connect("http://10.134.136.48:8000/prpall/business/editRenewalSearch.do")
			String url = ""
					+"http://10.134.136.48:8000/prpall/business/selectProposal.do"
					+ "?pageSize=20&pageNo="+ pageNo 
					+ "&comCode=11010283&riskCode=DAA&prpCproposalVo.checkFlag=&prpCproposalVo.underWriteFlag=&prpCproposalVo.strStartDate=&prpCproposalVo.othFlag=&prpCproposalVo.checkUpCode=&prpCproposalVo.operatorCode1=&prpCproposalVo.businessNature=&noNcheckFlag=0&jfcdURL=http://10.134.136.48:8100/cbc&prpallURL=http://10.134.136.48:8000/prpall&bizNoZ=&"
					+ "pageNo_=1&pageSize_=100&scmIsOpen=1111100000&searchConditionSwitch=0&queryinterval=04&electronicPolicyFlag=1&queryMenuFlag=1&prpCproposalVo.proposalNo=&prpCproposalVo.policyNo=&prpCproposalVo.licenseNo=&prpCproposalVo.vinNo=&prpCproposalVo.insuredCode=&prpCproposalVo.insuredName=&prpCproposalVo.contractNo="
					+ "&prpCproposalVo.operateDate=" + operateDate + "&prpCproposalVo.operateDate2=" + operateDate2
					+ "&prpCproposalVo.startDate=" + startDate + "&prpCproposalVo.startDate2=" + startDate2
					+ "&prpCproposalVo.underWriteFlag2=1&prpCproposalVo.underWriteFlag6=3&prpCproposalVo.underWriteFlagC=&prpCproposalVo.underWriteFlagD=D&prpCproposalVo.underWriteFlagE=E"
					+ "&prpCproposalVo.dmFlag=all&prpCproposalVo.underWriteFlagC=&prpCproposalVo.brandName=&prpCproposalVo.engineNo=&prpCproposalVo.frameNo=&prpCproposalVo.riskCode=DAA,DZA&prpCproposalVo.appliCode=&prpCproposalVo.apliName=&prpCproposalVo.makeCom=&makeComDes=&prpCproposalVo.operatorCode=&operatorCodeDes=&prpCproposalVo.comCode=&comCodeDes=&prpCproposalVo.handlerCode=&handlerCodeDes=&prpCproposalVo.handler1Code=&handler1CodeDes=&prpCproposalVo.endDate=&prpCproposalVo.endDate2=&prpCproposalVo.underWriteEndDate=&prpCproposalVo.underWriteEndDate2=";
			
			try {
//				System.out.println(url);
				con = Jsoup.connect( url)
					.cookies(getCookie()).timeout(1000 * 10);
				con.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");  
	            con.header("Accept-Encoding", "gzip, deflate, sdch");  
	            con.header("Accept-Language", "zh-CN,zh;q=0.8");  
	            con.header("User-Agent", "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.3; WOW64; Trident/7.0; .NET4.0E; .NET4.0C; Tablet PC 2.0; InfoPath.2; .NET CLR 3.5.30729; .NET CLR 2.0.50727; .NET CLR 3.0.30729)"); 
	            d=	con.post();
			} catch (Exception e) {
				Log.debug("错误信息:"+e.getMessage());
				continue;
			}

			Element s = d.body();
			// System.out.println(s.text());

			JSONObject json = JSON.parseObject(s.text());
			JSONArray array = json.getJSONArray("data");
			// System.out.println(array.size());
			if (0 == array.size()) {
				Log.debug("没数据了------------------------------------------");
				return;
			}

			for (int i = 0; i < array.size(); i++) {
				JSONObject o = array.getJSONObject(i);

				long ss = o.getJSONObject("startDate").getLong("time");
				String startdate = DateUtils.formateString_format(DateUtils.formatDate_ymdhms(new Date(ss)),
						"yyyy-MM-dd");
				String phone=phone((String) o.get("proposalNo"));
				try {
					Thread.sleep(1000 * 1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Log.info(
						startdate 
						+ "|" + o.get("licenseNo") 
						+ "|" + phone
						+ "|" + o.get("insuredName") 
						+ "|" + o.get("policyNo") 
						+ "|" + o.get("proposalNo"));
				;
//				System.out.println(startdate + "|" + o.get("licenseNo") + "|" + phone((String) o.get("proposalNo"))
//						+ "|" + o.get("insuredName") + "|" + o.get("policyNo") + "|" + o.get("proposalNo"));
//				;
				// long ss = o.getJSONObject("endDate").getLong("time");
				// System.out.println(DateUtils.formatDate_ymdhms(new
				// Date(ss))+"");
			}

			try {
				Thread.sleep(1000 * 4);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			pageNo++;
		}

	}
	
	

	
	// 查询 手机号 
	public String phone(String bizNo)  {
		Element s=null;
		Element ss=null;
		try {
		String sss=	"http://10.134.136.48:8000/prpall/business/showCinsured.do"
			+ "?systemCode="
			+ "&editType=SHOW_POLICY"
			+ "&bizType=POLICY"
			+ "&bizNo="+bizNo
			+ "&riskCode=DAA&minusFlag="
			+ "&contractNo="
			+ "&comCode=11010283"
			+ "&originQuery="
			+ "&beiRenewalFlag="
			+ "&proposalNo=TDAA201711010001891870"
			+ "&rnd822=Wed May 16 18:22:55 UTC+0800 2018";
//			/business/showCinsured.do
		Map<String, String> cookies = getCookie();
//		Thread.sleep(1000 * 1);
		Document d = null;
		String url = "http://10.134.136.48:8000/prpall/idcard/editIDCardCheck.do?bizNo="+bizNo;
		d = Jsoup.connect(url).cookies(cookies)
				.post();
		s = d.body();
		System.out.println("查询手机号返回结果:"+s);
//		String url = "http://10.134.136.48:8000/prpall/idcard/editIDCardCheck.do?bizNo="+bizNo;
		Document ht = Jsoup.connect(sss).cookies(cookies)
				.post();
		ss = ht.body();
		System.out.println("查询关系人信息返回结果:"+ss);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return s.select("#fm table tbody tr:eq(1) td:eq(1) input:eq(0)").val();
	}
}
