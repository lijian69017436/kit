package jdkprotxy.test;


import jdkprotxy.dao.JDKProxy;
import jdkprotxy.dao.PersonDAO;
import jdkprotxy.dao.PersonDAOImpl;




public class Test1 {
	public static void main(String[] args){
		PersonDAOImpl d=new PersonDAOImpl();
		JDKProxy proxy=new JDKProxy();
		PersonDAO p=(PersonDAO)proxy.createProxyInstance(d);
		p.getAll();
	}
}
