package xml_val.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;


public class PersonDAOImpl implements PersonDAO{
	
	private String name;
	private int age;
	private Person person; 
	private Person perClass;
	private List list;
	private Object[] obj;
	private Map map;
	private Set set;
	private Properties prop;
	private List listNull;
	
	
	public void getAll() {
		System.out.println("impl :"+this.name+"---"+this.age); //�Դ� ��װ�ֶε�����
		
		if (person!=null){
			System.out.println("person"+person.getPname()+"   "+person.getPtel());
		}
		if (perClass!=null){
			System.out.println(person.getPname()+"   "+person.getPtel());
		}
		
		if (list.size()>0){
			for(int i=0;i<list.size();i++){
				System.out.println("list"+list.get(i));
			}
		}
		if (obj.length>0){
			for(int i=0;i<obj.length;i++){
				System.out.println("obj"+list.get(i));
			}
		}
		if(map.size()>0){
			System.out.println(map.get("key01"));
			System.out.println(map.get("key02"));
		}
		if(set.size()>0){
			for(Iterator it=set.iterator(); it.hasNext();){
				System.out.println("set "+it.next());
			}
		}
		if(prop!=null&&prop.size()>0){
			System.out.println(prop.getProperty("prop1"));
			System.out.println(prop.getProperty("prop2"));
		}
		System.out.println("list null:"+listNull);
		
	}
	
	
	
	public Person getPerClass() {
		return perClass;
	}


	public void setPerClass(Person perClass) {
		this.perClass = perClass;
	}


	public Person getPerson() {
		return person;
	}


	public void setPerson(Person person) {
		this.person = person;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}



	public List getList() {
		return list;
	}



	public void setList(List list) {
		this.list = list;
	}



	public Object[] getObj() {
		return obj;
	}



	public void setObj(Object[] obj) {
		this.obj = obj;
	}



	public Map getMap() {
		return map;
	}



	public void setMap(Map map) {
		this.map = map;
	}



	public Set getSet() {
		return set;
	}



	public void setSet(Set set) {
		this.set = set;
	}



	public Properties getProp() {
		return prop;
	}



	public void setProp(Properties prop) {
		this.prop = prop;
	}



	public List getListNull() {
		return listNull;
	}



	public void setListNull(List listNull) {
		this.listNull = listNull;
	}
	
}