package db.hibernate.one.zbx;

import java.io.Serializable;
import java.util.HashMap;

import com.zbxsoft.core.orm.Page;
import com.zbxsoft.core.orm.hibernate.ZbxBaseDao;

public class sql extends ZbxBaseDao<sql, Serializable>{

	//根据sql 查询 一个list 集合
	//根据 sql 查询一个page 集合
	
	
	//这句话的意思是  这个dao 继承了这个类   可以用这个类自带的方法
	//class StaffDao extends ZbxBaseDao<Staff, String>
	
	public void sqlTest(){
		getPageListBySql("sql", 10, 2, sql.class);
		getMapPageListBySql("sql", 10, 2);
		
		findPage(new Page<sql>(), "hql", new HashMap<String, Object>());
		findPage(new Page<sql>(), "hql", new Object[]{"value","value"});
		
	}
}
