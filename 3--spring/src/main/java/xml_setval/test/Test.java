package xml_setval.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import xml_setval.dao.PersonDAO;

public class Test {
	public static void main(String[] args){
		@SuppressWarnings("resource")
		ApplicationContext act=new ClassPathXmlApplicationContext("xml_setval/applicationContext.xml");
	
		PersonDAO dao=(PersonDAO) act.getBean("personDAO");
		
		dao.getAll();
	}
}
