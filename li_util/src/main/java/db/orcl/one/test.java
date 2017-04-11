package db.orcl.one;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import db.orcl.one.dao.impl.EmpsImpl;

public class test {

	@Test
	public  void test_select_emps() {
		long w =System.currentTimeMillis(); 
		EmpsImpl dao=new EmpsImpl();
		List<Map<String,Object>> list= dao.select_emps()     ;
		long e =System.currentTimeMillis();  
		System.out.println(e-w);
		for(Map<String ,Object> s:list){
			System.out.println(s.get("empno"));
		}
		
		
	}
}
