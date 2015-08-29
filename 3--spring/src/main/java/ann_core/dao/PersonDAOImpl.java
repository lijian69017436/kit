package ann_core.dao;

import org.springframework.stereotype.Repository;

@Repository("personDAO") 
public class PersonDAOImpl implements PersonDAO{
	public void getAll() {
		System.out.println("------>   dao getall  methd-----");
	}

	
}