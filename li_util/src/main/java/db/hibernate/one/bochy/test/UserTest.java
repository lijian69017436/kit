package db.hibernate.one.bochy.test;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.json.JSONObject;
import org.junit.Test;

import db.hibernate.one.bochy.dao.HibernateSessionFactory;
import db.hibernate.one.bochy.dao.pojo.User;

/**
 * 第一次 接触 hibernate 各种 方法 和原理 
 *
 */
public class UserTest {
		//创建 一个表
			  	/*  读取  hibernate 配置文件 ， 
					Configuration cfg=new Configuration().configure();
					//工具利用实体类 和映射文件生成数据库端的 表结构
					SchemaExport export=new SchemaExport(cfg);
					/*
					 * 第一个参数 ：把ddl语句输出到控制台上
					 * 第二个参数：根据实体类 和映射文件 先执行 删除操作在创建表结构；
					 */
	            //	export.create(true,true);
	private Session  session=HibernateSessionFactory.getSession();
	//查询方法 --通过唯一主键  ，加载一行数据，方法用get（）
	@Test
	public void getMethod(){
		
		User u=(User)session.get(User.class, 2);
		System.out.println(u.getUsername());
		
	}
	@Test
	public void listMethod(){//查询 所有 
		//实体查询 from 是sql 的关键字 User是类名称
		@SuppressWarnings("unchecked")
		List<User> list=session.createQuery("from User").list();
		System.out.println(list.size());
		for(User u:list){
			System.out.println(new JSONObject(u));
		}
	}
	//插入
	@Test
	public void insertUser(){
		Transaction tr=null;
		try {
			//开启事务
			 tr=session.beginTransaction();
			User u=new User();
			u.setId(1);
			u.setUsername("dd");
			u.setPwd("22");
			session.save(u);
			tr.commit();//事务提交
		} catch (HibernateException e) {
			e.printStackTrace();
			tr.rollback();//事务回滚
		}
	}
	//更新
	@Test
	public void update(){
		session.beginTransaction(); //开启事务
		User u=new User();
		u.setId(2);
		u.setUsername("admin");
		u.setPwd("123");
		session.update(u);
		session.beginTransaction().commit();
	}
	
	public void delete(){
		session.beginTransaction();
		User u=new User();
		u.setId(2);
		session.delete(u);
		session.beginTransaction().commit();
	}
	public static void main(String[] args) {
		UserTest ie=new UserTest();
		ie.listMethod();
	}
}
