package db.hibernate.one.procedure;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class Test1 {
/**
 * 调用 函数的 方法
 * @param args
 */
	public static void main(String[] args) {
		 Session session=HibernateSessionFactory.getSession();
		 Query query= session.getNamedQuery("selectEmpByProcedure");
       	 query.setInteger(0, 20);
       	List<Emp> list= query.list();
       	for(int i=0;i<list.size();i++){
       		System.out.println(list.get(i).getEname());
       	}
		// List list=session.createCriteria(Emp.class).list();
        
	}

}

