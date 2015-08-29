package domPa_resXML.dao;

import java.util.List;

import domPa_resXML.entity.Person;

public interface PersonDao {
	
  /**
	* 根据身份证号查询这个人的信息；
   **/
	public Person selectPersonByCardno(String cardno,String xmlPath) throws Exception;
	
  /**
   * 查询数据；
   * */
	public List<Person> selectPersonList(String xmlPath) throws Exception;
 /**
  * 新增数据：
  * */
	public void addPerson(Person person,String xmlPath) throws Exception;
	
	/**
	 *  修改指定的person;按照cardno省份证号修改数据
	 * */	
	public void updatePerson(Person person,String xmlPath)throws Exception;
	
  /**
   * 删除person，按照cardno删除；
   * */
	public void deletePerson(String cardno,String xmlPath)throws Exception;
	
  /**
   * 登陆： 用户名为cardno， 密码默认为：cardno后三位
   * */
	public Boolean login(String username,String pwd,String xmlPath) throws Exception;
}
