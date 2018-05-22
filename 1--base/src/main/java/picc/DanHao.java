package picc;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
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
import picc.common.PropertiesUtil;
import picc.common.PropertiesUtils;

public class DanHao extends Base{
	 public  Logger  dataLog=Logger.getLogger("data");
	 public static  Logger  Log=Logger.getLogger("base");
	 
	 static {
		 PropertiesUtil ins = PropertiesUtil.getInstance();
		 String mm=ins.getValue("mm");
		 System.setProperty ("WORKDIR", mm);
	 }
	static int status=0; //记录 错误异常信息  ,达到3次就结束此次任务
	private IdentifyNumber identifyNumberBean=new IdentifyNumber();
	private Phone phoneBean=new Phone();
	List<List> list = new ArrayList<List>();
	private  String str="";
	int pageNo;
	
	Map<String,String> cache=	new HashMap<String,String>();
	String startDate;
	String startDate2;
//URL	协议	方法	结果	类型	已接收	已花费	发起程序	等候‎‎	开始‎‎	请求‎‎	响应‎‎	已读取缓存‎‎	差距
	public static void main(String[] args) {
		
		
		DanHao danhao=new DanHao();
		String startTime=danhao.getStartTime(); //起保日期
		String endTime; //结束日期
		
		PropertiesUtil ins = PropertiesUtil.getInstance();
		String mm=ins.getValue("mm");
		
		for(int i=0;i<6;i++) {
			endTime=DateUtils.get_DD_and5(startTime); //
			
			String yy=ins.getValue("yy")+"";
			String user="_"+ins.getValue("user")+".xls";
			
			danhao.danhaoRun(startTime,endTime,yy+mm+user);
			
			
			mm=DateUtils.formateString_format(endTime,"MM"); //得到 月份  设置月份
			
			
			PropertiesUtils.getInstance().setProperty("pageNo","1"); //初始化  第一页
			status=0;
			
			if(startTime.equals(endTime)) {
				Log.debug("这个月已经结束了 , "+mm+"月");
				return ;
			}
			startTime=endTime; //循环结束  开始日期 等于结束日期
		}
		
		
		
		
	}
	
	//根据  开始时间  结束 时间   文件名 来写入数据到文件
	public void danhaoRun(String startDate,String startDate2,String excelName) {
		this.startDate=startDate;
		this.startDate2=startDate2;
		
		danhao();
		
		PropertiesUtils.getInstance().setProperty("pageNo",pageNo+"");
		list.clear();
		Log.debug("list:大小:"+list.size());
		try {
			ExcelKit d=new ExcelKit();
			d.createExcel(getValue("excelPath"),excelName,  list, 
					startDate+"到"+startDate2, false);;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 查询单号 
	@Test
	public void danhao()  {
			
		String operateDate = "";//签单日期
		String operateDate2 = "";
		
		
		dataLog.info("时间:"+startDate);
		dataLog.info("时间:"+startDate2);
		Log.debug("excel名字:"+getExcelName());
		pageNo = Integer.valueOf((String)PropertiesUtils.getInstance().getValue("pageNo"));
		while (true) {
			if (Integer.valueOf(getValue("pageNoT")) == pageNo) {
				break;
			}
			if(status==3) {//错误信息
				Log.debug("时间:"+startDate+"  结束时间:"+startDate2 +"发生错误异常 3次以上");
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
					+ "&pageSize_=20"
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
					.timeout(1000 * 30);
				con.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");  
	            con.header("Accept-Encoding", "gzip, deflate, sdch");  
	            con.header("Accept-Language", "zh-CN,zh;q=0.8");  
	            con.header("User-Agent", "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.3; WOW64; Trident/7.0; .NET4.0E; .NET4.0C; Tablet PC 2.0; InfoPath.2; .NET CLR 3.5.30729; .NET CLR 2.0.50727; .NET CLR 3.0.30729)"); 
	            d=	con.post();
			} catch (Exception e) {
				Log.debug("错误信息:"+e.getMessage());
				status++;
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
				status++;
			}
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
			
			dataLog.info(str);
			List<String> row  =new ArrayList<String>();
			row.add(insuredName);
			row.add(phone);
			row.add(licenseNo);
			row.add(proposalNo);
			row.add(policyNo);
			row.add(identifyNumber);
			row.add(startdate);
			list.add(row);
			if(status==3) {
				return;
			}
		}

	}
	
}
