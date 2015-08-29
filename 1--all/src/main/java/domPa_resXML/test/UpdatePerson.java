package domPa_resXML.test;

import java.util.List;

import domPa_resXML.dao.PersonDao;
import domPa_resXML.daoImpl.PersonDaoImpl;
import domPa_resXML.entity.Person;

public class UpdatePerson {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		 Person person=new Person();
		 person.setCardno("1002");
		 person.setName("王3");
		 person.setAddress("黑龙江省省");
		 person.setBirthday("19871010");
		 person.setAge(11);
		 PersonDao dao=new PersonDaoImpl();
		 dao.updatePerson(person, "com/bochy/xml/person.xml");
		 
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
