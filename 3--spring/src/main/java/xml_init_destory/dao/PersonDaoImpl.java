package xml_init_destory.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;



public class PersonDaoImpl  implements PersonDao {
	
	public List<Map<String ,Object>> getAll() {
		List<Map<String ,Object>> list=new ArrayList<Map<String,Object>>();
		System.out.println("select  * from   db");
		return list;
	}

	public void init() {
		System.out.println("init======----");
	}

	public void destroy() {
		System.out.println("-========destroy=--------");
	}

}
