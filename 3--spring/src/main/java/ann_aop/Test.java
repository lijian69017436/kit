package ann_aop;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ann_aop.dao.PersonDAO;
import ann_aop.dao.PersonDaoImpl;




public class Test {
	public static void main(String[] args){
		ApplicationContext act=new ClassPathXmlApplicationContext("ann_aop/applicationContext.xml");
	
		PersonDAO dao=(PersonDAO) act.getBean(PersonDAO.DAO_NAME);
		dao.savePerson("d", "00");
	}
}
