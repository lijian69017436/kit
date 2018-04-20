package db.hibernate.one.bochy.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import db.hibernate.one.bochy.dao.pojo.User;



@SuppressWarnings("unchecked")
public class UserDaoItem {
	
	private Session  session=HibernateSessionFactory.getSession();
	public List<User> paging(int pageNow,int pageSize){
		List<User> list=session.createQuery("from User")
		.setFirstResult(pageNow) 
		.setMaxResults(pageSize)	
		.list();
		
		return list;
	}
	public void delete(int id){
		Transaction tr=session.beginTransaction();
		User u=new User();
		u.setId(id);
		session.delete(u);
		tr.commit();
	}
	public void insertUser(User u){
		Transaction tr=null;
		try {
			tr=session.beginTransaction();
			session.save(u);
			tr.commit();
			
		} catch (HibernateException e) {
			e.printStackTrace();
			tr.rollback();
		}
	}
	public void updateUser(User u){
		Transaction tr=null;
		try {
			tr=session.beginTransaction();
			session.update(u);
			tr.commit();
			
		} catch (HibernateException e) {
			e.printStackTrace();
			tr.rollback();
		}
	}
	public  User selectByid(int id){
		User u=(User)session.get(User.class, id);
		return u;
	}
}
