package ann_core.test;


import org.springframework.context.support.ClassPathXmlApplicationContext;

import ann_core.dao.PersonDAO;
import ann_core.service.PersonsService;




public class Test {
	
	
	public static void main(String[] args){
		ClassPathXmlApplicationContext act=new ClassPathXmlApplicationContext("ann_core/applicationContext.xml");
	
		PersonDAO dao=(PersonDAO) act.getBean("personDAO");
		//dao.getAll();
		PersonsService ser=(PersonsService)act.getBean("personService");
		ser.getAll();
	}
}
