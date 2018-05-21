package picc;

import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class IdentifyNumber extends Base{

	
	/**
	 * 
	 * @Description: TODO( 查询 身份证)  
	 * @param proposalNo 投保单号
	 * @return
	 */
	public String getIdentifyNumber(String proposalNo ) {
		try {
			Thread.sleep(1000 * 1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Element s=null;
		//查询 身份证  
		String ddf="http://10.134.136.48:8000/prpall/business/showCinsured.do" + 
				"?systemCode=" + 
				"&editType=SHOW_PROPOSAL" + 
				"&bizType=PROPOSAL" + 
				"&bizNo=" +proposalNo+
				"&riskCode=DAA&minusFlag=" + 
				"&contractNo=" + 
				"%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20" + 
				"&comCode=11010283" + 
				"&originQuery=" + 
				"&beiRenewalFlag=" + 
				"&proposalNo=" +proposalNo+ 
				"&rnd243=" +new Date()+ 
				"";
		
		Document d = null;
		try {
			d = Jsoup.connect(ddf).cookies(getCookie())
					.timeout(1000*10)
					.post();
			s = d.body();
			//System.out.println(d.body());
			//身份证 
			String IdentifyNumber =s.select("#insertInsuredRow  tbody tr:eq(1) td:eq(5) input:eq(1)").val();
//			System.out.println(s.select("#insertInsuredRow  input[name^=showIdentifyNumber*]  ").html());
//			System.out.println(s.select("#insertInsuredRow  input:eq(0)  ").val());
//			System.out.println(s.select("#insertInsuredRow  input[name^=showIdentifyNumber*]  ").html());
//			System.out.println(s.select("#showIdentifyNumber[0]").html());
			return IdentifyNumber;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "";
	}
}
