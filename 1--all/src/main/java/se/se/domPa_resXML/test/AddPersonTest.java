package se.se.domPa_resXML.test;

import java.util.List;

import se.se.domPa_resXML.dao.PersonDao;
import se.se.domPa_resXML.daoImpl.PersonDaoImpl;
import se.se.domPa_resXML.entity.Person;

public class AddPersonTest {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		PersonDao dao=new PersonDaoImpl();
		Person person =new Person();
		person.setCardno("1005");
		person.setName("张小二");
		person.setAge(23);
		person.setBirthday("20140111");
		person.setAddress("北京");
		//新增数据；
		dao.addPerson(person, "com/bochy/xml/person.xml");
		//查询：
		List<Person> list=dao.selectPersonList("com/bochy/xml/person.xml");
		if(list!=null&&list.size()>0){
			for(int i=0;i<list.size();i++){
				Person p=list.get(i);
				System.out.println(p.getCardno()+":"+p.getName()+":"+p.getAge()+
						":"+p.getAddress()+":"+p.getBirthday());
			}
		}

	}

}
