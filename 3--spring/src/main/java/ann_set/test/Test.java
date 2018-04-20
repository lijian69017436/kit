package ann_set.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ann_set.service.PersonsService;

public class Test {
  
  
	public static void main(String[] args){
		ApplicationContext act=new ClassPathXmlApplicationContext("ann_set/applicationContext.xml");
	
		PersonsService dao= act.getBean(PersonsService.class);
		
		dao.getAll();
	}
	
	
}
