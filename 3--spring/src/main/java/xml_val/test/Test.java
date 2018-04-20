package xml_val.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import xml_val.dao.PersonDAO;

public class Test {
	public static void main(String[] args){
		ApplicationContext act=new ClassPathXmlApplicationContext("xml_val/applicationContext.xml");
	
		PersonDAO dao=(PersonDAO) act.getBean("personDAO");
		
		dao.getAll();
	}
}
