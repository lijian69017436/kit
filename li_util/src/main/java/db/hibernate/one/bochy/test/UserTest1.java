package db.hibernate.one.bochy.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import db.hibernate.one.bochy.dao.HibernateSessionFactory;
import db.hibernate.one.bochy.dao.pojo.User;

/**
 * 测试  各种 方法 的类  用来测试 hibernate  
 * 3种状态
 * @author Administrator
 *
 */

public class UserTest1 {
	private Transaction tr=null;
	private Session  session=HibernateSessionFactory.getSession();

	//批量添加
	@Test
	public  void insert(){
		Transaction tr=session.beginTransaction();
		for(int i=0;i<10;i++){//批量添加
			User user=new User();
			user.setId(10+i);
			user.setUsername("李健_"+i);
			user.setPwd("pp"+i);
			session.save(user);
		}
		tr.commit();
	}
	//3中状态的 解析
	public  void insert2(){
		Transaction tr=session.beginTransaction();
			//瞬时状态
			User user=new User();
			//持久状态
			user.setId(10);
			user.setUsername("李健_");
			user.setPwd("pp");
			session.save(user);
			user.setUsername("丁丁");
			//当持久化的数据发生变化时，与数据库同步执行
			session.update(user);
		tr.commit();
		session.close();
		//游离状态
		user.setUsername("张");
		  tr=session.beginTransaction();
		  session.update(user);
		  tr.commit();
	}
	//得到  数据 在 同步 数据
	public  void getMethod(){
		
		User u=(User)session.get(User.class, 1);
		tr=session.beginTransaction();
		//当数据持久状态时，数据发生改变，与数据库同步
		u.setUsername("张三");
		tr.commit();
	}
	
	//使用get 方法加载数据时，如果id 不存在。则返回null，不会报错
	public  void getMethod2(){
		User u=(User)session.get(User.class, 122222);
		//当数据持久状态时，数据发生改变，与数据库同步
		System.out.println(u);
	}
	
	//
	public  void loadMethod1(){
		User u=(User)session.load(User.class, 1);
		//当数据持久状态时，数据发生改变，与数据库同步
		System.out.println(u.getUsername()+" "+u.getPwd());
		tr=session.beginTransaction();
		u.setUsername("妹妹");
		tr.commit();
	}
	//数据库没有数据就会报错
	public  void loadMethod2(){
		User u=(User)session.load(User.class, 1111);
		//当数据持久状态时，数据发生改变，与数据库同步
		System.out.println(u.getUsername()+" "+u.getPwd());
		tr=session.beginTransaction();
		u.setUsername("妹妹");
		tr.commit();
	}
	//分页 原理
	public List<User> paging(int pageNow,int pageSize){
		@SuppressWarnings("unchecked")
		List<User> list=session.createQuery("from User")
		.setFirstResult(pageNow) //开始显示记录数的行号
		.setMaxResults(pageSize)	//每页最大的记录数
		.list();
		
		return list;
	}
	
}
