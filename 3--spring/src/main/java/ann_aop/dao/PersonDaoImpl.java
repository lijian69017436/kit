package ann_aop.dao;

import org.springframework.stereotype.Repository;

@Repository(PersonDAO.DAO_NAME)
public class PersonDaoImpl implements PersonDAO{

	public void getAll() {
		System.out.println("����dao getall-----");
	}
	public void savePerson(String username ,String pwd){
		System.out.println(username+"\t"+pwd);
	}
	
	
	
}