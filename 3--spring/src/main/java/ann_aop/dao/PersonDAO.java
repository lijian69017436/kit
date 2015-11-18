package ann_aop.dao;


public interface PersonDAO {
	public static  final String DAO_NAME="personDao";
	
	public void getAll();
	public void savePerson(String username ,String pwd);
	
}