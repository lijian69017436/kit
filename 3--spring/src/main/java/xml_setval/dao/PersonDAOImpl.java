package xml_setval.dao;



public class PersonDAOImpl implements PersonDAO{
	
	private String name;
	private Integer age;
	
	public PersonDAOImpl(){}
	
	public PersonDAOImpl(String name,Integer age){
		this.name=name;
		this.age=age;
		System.out.println("init  persondaoimpl");
	}
	
	public void getAll() {
		System.out.println("impl  parmaeter:"+this.name+"---"+this.age); //�Դ� ��װ�ֶε�����
		
	}
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}




	
}