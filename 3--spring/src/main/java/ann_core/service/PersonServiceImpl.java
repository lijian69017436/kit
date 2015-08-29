package ann_core.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ann_core.dao.PersonDAO;

//@Controller("loginAction") //struts2
@Service("personService")
public class PersonServiceImpl implements PersonsService {
	
	@Resource(name="personDAO") 
	private PersonDAO dao;
	
	public void getAll() {
		System.out.println("����service��getall");
		dao.getAll();
	}

}
