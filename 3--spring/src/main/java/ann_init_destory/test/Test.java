package ann_init_destory.test;




import org.springframework.context.support.ClassPathXmlApplicationContext;

import ann_init_destory.dao.PersonDAO;



public class Test {
  
	public static void main(String[] args){
		
	  ClassPathXmlApplicationContext act=new ClassPathXmlApplicationContext("ann_init_destory/applicationContext.xml");
		PersonDAO dao= act.getBean(PersonDAO.class);
		
		dao.getAll();
		act.close();
	}
	
}
