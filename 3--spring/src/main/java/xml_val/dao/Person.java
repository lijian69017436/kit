package xml_val.dao;

public class Person {
	private String pname="����";
	private String ptel="110";
	
	public Person(){
		System.out.println("person�Ĺ��췽��");
	}
	
	
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPtel() {
		return ptel;
	}
	public void setPtel(String ptel) {
		this.ptel = ptel;
	}
}
