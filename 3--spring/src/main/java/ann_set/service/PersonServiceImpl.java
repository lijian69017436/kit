package ann_set.service;

import org.springframework.beans.factory.annotation.Autowired;

import ann_set.dao.PersonDAO;



public class PersonServiceImpl implements PersonsService {
	
	private PersonDAO dao;
	
	
	
	
	public void getAll() {
		System.out.println(this.getClass().toString()+"----> getAll method");
		dao.getAll();
	}
	
	public PersonDAO getDao() {
		return dao;
	}
	@Autowired
	public void setDao(PersonDAO dao) {
		this.dao = dao;
	}

	
}
