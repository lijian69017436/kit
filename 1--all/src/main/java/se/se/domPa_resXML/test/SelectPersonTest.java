package se.se.domPa_resXML.test;

import java.util.List;

import se.se.domPa_resXML.dao.PersonDao;
import se.se.domPa_resXML.daoImpl.PersonDaoImpl;
import se.se.domPa_resXML.entity.Person;

public class SelectPersonTest {
	public static void main(String args[]) throws Exception{
		PersonDao dao=new PersonDaoImpl();
		List<Person> list=dao.selectPersonList("com/bochy/xml/person.xml");
		if(list!=null&&list.size()>0){
			for(int i=0;i<list.size();i++){
				Person person=list.get(i);
				System.out.println(person.getCardno()+":"+person.getName()+":"+person.getAge()+
						":"+person.getAddress()+":"+person.getBirthday());
			}
		}
		 
	}
}
