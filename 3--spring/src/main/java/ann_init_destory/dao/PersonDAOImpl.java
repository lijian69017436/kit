package ann_init_destory.dao;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;



public class PersonDAOImpl implements PersonDAO{
	@PostConstruct //init
	public void init(){
		System.out.println("----->  init");
	}
	public void getAll() {
		System.out.println(" ------->  dao getall-----");
		
	}
	@PreDestroy //destroy
	public void destroy(){
		System.out.println("------->  destroy");
	}


	
}