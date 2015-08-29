package action;

import com.opensymphony.xwork2.ActionSupport;

public class l extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private q ee;
	
	public String yonghuming(){
		System.out.println("ff");
		System.out.println("   ++"+ee.getName());
		return null;
		
		
	}

	public q getEe() {
		return ee;
	}

	public void setEe(q ee) {
		this.ee = ee;
	}
	
	
}
