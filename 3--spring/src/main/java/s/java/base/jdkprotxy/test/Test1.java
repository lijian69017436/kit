package s.java.base.jdkprotxy.test;


import s.java.base.jdkprotxy.dao.JDKProxy;
import s.java.base.jdkprotxy.dao.PersonDAO;
import s.java.base.jdkprotxy.dao.PersonDAOImpl;




public class Test1 {
	public static void main(String[] args){
		PersonDAOImpl d=new PersonDAOImpl();
		JDKProxy proxy=new JDKProxy();
		PersonDAO p=(PersonDAO)proxy.createProxyInstance(d);
		p.getAll();
	}
}
