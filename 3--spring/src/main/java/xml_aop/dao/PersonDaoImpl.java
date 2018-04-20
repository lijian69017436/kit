package xml_aop.dao;


public class PersonDaoImpl implements PersonDAO{
	private PersonDAO personDao;
	
	public void getAll() {
		System.out.println("  dao getall-----");
	}
	public void savePerson(String username ,String pwd){
		System.out.println(username+"\t"+pwd);
	}
	
	public PersonDAO getPersonDao() {
		return personDao;
	}
	public void setPersonDao(PersonDAO personDao) {
		this.personDao = personDao;
	}
	
	
}