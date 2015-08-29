package xml_aop.test;


import org.springframework.context.support.ClassPathXmlApplicationContext;

import xml_aop.dao.PersonDAO;




public class Test {
	@SuppressWarnings("resource")
	public static void main(String[] args){
		ClassPathXmlApplicationContext act=new ClassPathXmlApplicationContext("xml_aop/applicationContext.xml");
		PersonDAO dao=(PersonDAO) act.getBean("perDao");
		dao.getAll();
	}
}
