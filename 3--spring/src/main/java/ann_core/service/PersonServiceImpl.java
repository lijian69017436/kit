package ann_core.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ann_core.dao.PersonDAO;

//@Controller("loginAction") //struts2
@Service("personService")
public class PersonServiceImpl implements PersonsService {
	
	@Autowired() 
	private PersonDAO dao;
	
	public void getAll() {
		System.out.println(this.getClass().getName());
		dao.getAll();
	}

}
