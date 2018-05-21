package picc;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lijian.util.ValidUtils;

import picc.common.DateUtils;
import picc.common.ExcelKit;
import picc.common.Log;
import picc.common.PropertiesUtils;

public class DanHao extends Base{

	private IdentifyNumber identifyNumberBean=new IdentifyNumber();
	private Phone phoneBean=new Phone();
	List<List> list = new ArrayList<List>();
	
	private  String str="";
	
	Map<String,String> cache=	new HashMap<String,String>();
   
//URL	协议	方法	结果	类型	已接收	已花费	发起程序	等候‎‎	开始‎‎	请求‎‎	响应‎‎	已读取缓存‎‎	差距
	public static void main(String[] args) {
		new DanHao().danhao();
	}
		
	// 查询单号 
	@Test
	public void danhao()  {
			
		String operateDate = "";//签单日期
		String operateDate2 = "";
		String startDate = getValue("startTime");//起保日期
		String startDate2 = getValue("endTime");
		
		Log.debug("时间:"+startDate);
		Log.debug("时间:"+startDate2);
		int pageNo = Integer.valueOf((String)PropertiesUtils.getInstance().getValue("pageNo"));
		while (true) {
			if (Integer.valueOf(getValue("pageNoT")) == pageNo) {
				break;
			}
			
			
			Document d = null;
			Connection con=null;
			
			String url = ""
					+"http://10.134.136.48:8000/prpall/business/selectProposal.do"
					+ "?pageSize=20"
					+ "&pageNo="+ pageNo 
					+ "&comCode=11010283"
					+ "&riskCode=DAA"
					+ "&prpCproposalVo.checkFlag="
					+ "&prpCproposalVo.underWriteFlag="
					+ "&prpCproposalVo.strStartDate="
					+ "&prpCproposalVo.othFlag="
					+ "&prpCproposalVo.checkUpCode="
					+ "&prpCproposalVo.operatorCode1="
					+ "&prpCproposalVo.businessNature="
					+ "&noNcheckFlag=0"
					+ "&jfcdURL=http://10.134.136.48:8100/cbc"
					+ "&prpallURL=http://10.134.136.48:8000/prpall"
					+ "&bizNoZ=&"
					+ "pageNo_="+pageNo
					+ "&pageSize_=100"
					+ "&scmIsOpen=1111100000"
					+ "&searchConditionSwitch=0"
					+ "&queryinterval=04"
					+ "&electronicPolicyFlag=1"
					+ "&queryMenuFlag=1"
					
					
					+ "&prpCproposalVo.proposalNo="
					+ "&prpCproposalVo.policyNo="
					+ "&prpCproposalVo.licenseNo="
					+ "&prpCproposalVo.vinNo="
					+ "&prpCproposalVo.insuredCode="
					+ "&prpCproposalVo.insuredName="
					+ "&prpCproposalVo.contractNo="
					+ "&prpCproposalVo.operateDate=" + operateDate 
					+ "&prpCproposalVo.operateDate2=" + operateDate2
					+ "&prpCproposalVo.startDate=" + startDate 
					+ "&prpCproposalVo.startDate2=" + startDate2
					+ "&prpCproposalVo.underWriteFlag2=1" //通过
					+ "&prpCproposalVo.underWriteFlag6=3" //自动核保通过
					+ "&prpCproposalVo.underWriteFlagC="
					+ "&prpCproposalVo.underWriteFlagD=D" //自动核保转保单
					+ "&prpCproposalVo.underWriteFlagE=E" //人工核保转保单
					+ "&prpCproposalVo.underWriteFlagC="
					+ "&prpCproposalVo.dmFlag=all"
					+ "&prpCproposalVo.brandName="
					+ "&prpCproposalVo.engineNo="
					+ "&prpCproposalVo.frameNo="
					+ "&prpCproposalVo.riskCode=DAA,DZA"
					+ "&prpCproposalVo.appliCode="
					+ "&prpCproposalVo.apliName="
					+ "&prpCproposalVo.makeCom="
					
					+ "&makeComDes="
					+ "&prpCproposalVo.operatorCode="
					+ "&operatorCodeDes="
					+ "&prpCproposalVo.comCode="
					+ "&comCodeDes="
					+ "&prpCproposalVo.handlerCode="
					+ "&handlerCodeDes="
					+ "&prpCproposalVo.handler1Code="
					+ "&handler1CodeDes="
					+ "&prpCproposalVo.endDate="
					+ "&prpCproposalVo.endDate2="
					+ "&prpCproposalVo.underWriteEndDate="
					+ "&prpCproposalVo.underWriteEndDate2=";
			try {
				con = Jsoup.connect( url)
					.cookies(getCookie())
					.timeout(1000 * 10);
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
			//得到 data
			JSONArray array = json.getJSONArray("data"); 
			String atotalRecordsy = json.getString("totalRecords"); 
			if (0 == array.size()) {
				Log.debug("没数据了------------------------------------------");
				break;
			}
			System.out.println("总条数  "+atotalRecordsy  +"  当前页" +pageNo);
			
			paresJson(array);
			pageNo++;
			
			try {
				Thread.sleep(1000 * 4);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		PropertiesUtils.getInstance().setProperty("pageNo",pageNo+"");
		try {
			ExcelKit d=new ExcelKit();
			d.createExcel("C:\\Users\\Administrator\\Desktop\\", "1.xls", list, startDate+"到"+startDate2, false);;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @Description: TODO(  解析  数据)  
	 * @version V1.0   
	 * @param array
	 */
	private void paresJson(JSONArray array) {
		for (int i = 0; i < array.size(); i++) {
			JSONObject o = array.getJSONObject(i);

			long ss = o.getJSONObject("startDate").getLong("time");
			String startdate = DateUtils.formateString_format(DateUtils.formatDate_ymdhms(new Date(ss)),
					"yyyy-MM-dd");
			String licenseNo=o.getString("licenseNo");  //车牌
			String insuredName =o.getString("insuredName"); //名字
			String proposalNo =o.getString("proposalNo"); //投保单号
			String policyNo =o.getString("policyNo"); //保单号
			
			if(cache.containsKey(licenseNo)) {
				continue;
			}
			//根据车牌去重 
			cache.put(licenseNo, licenseNo);
			
			//根据身份证   去机构
			String identifyNumber = identifyNumberBean.getIdentifyNumber(proposalNo);
			identifyNumber=identifyNumber.trim();
			System.out.println("是否是身份证 :"+ValidUtils.isIDCard(identifyNumber) +"____"+identifyNumber +"___投保单号:"+proposalNo );
			if(!ValidUtils.isIDCard(identifyNumber)) {
				continue;
			}
			String phone =phoneBean.getPhone(identifyNumber);
			
			str=	startdate 
					+ "|" + licenseNo
					+ "|" + insuredName 
					+ "|" + proposalNo 
					+ "|" + policyNo
					+ "|" + identifyNumber
					+ "|" + phone
					;
			Log.debug(str);
			List<String> row  =new ArrayList<String>();
			row.add(insuredName);
			row.add(phone);
			row.add(licenseNo);
			row.add(proposalNo);
			row.add(policyNo);
			row.add(identifyNumber);
			row.add(startdate);
			list.add(row);
		}

	}
	
}
