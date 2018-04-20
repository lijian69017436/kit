package xml_init_destory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import xml_init_destory.dao.PersonDao;


public class test1 {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext act=new ClassPathXmlApplicationContext("xml_init_destory/applicationContext.xml");
		
		PersonDao dao=(PersonDao)act.getBean("personDao");
		dao.getAll();
		
	}
}
