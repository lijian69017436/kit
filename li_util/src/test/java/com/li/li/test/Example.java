package com.li.li.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.junit.Test;

import com.li.li.Photo;
import com.li.li.PhotoDao;
import com.li.li.jdbc.HibernateSessionFactory;
import com.zbxsoft.core.mapper.CollectionMapper;
import com.zbxsoft.core.orm.Page;

public class Example {

	@Test
	public void zbxbaseDao() throws IOException{
		SessionFactory sf = HibernateSessionFactory.getSessionFactory();
		PhotoDao dao = new PhotoDao();
		dao.setSessionFactory(sf);
		
		dao.getPageListBySql("sql", 10, 2, Photo.class);
		dao.getMapPageListBySql("sql", 10, 2);
		
		dao.findPage(new Page<Photo>(), "hql", new HashMap<String, Object>());
		dao.findPage(new Page<Photo>(), "hql", new Object[]{"value","value"});
		
		
		dao.getAll(); 
		
		//1, 根据sql查询 一条记录 
		//
	}
	
	@Test
	public void mapperCollection(){
		
		ArrayList<Photo> list = new ArrayList<Photo>();
		Photo ph = new Photo();
		ph.setId("d");
		ph.setPath("ddddd");
		Photo ph1 = new Photo();
		ph1.setId("2");
		ph1.setPath("3333");
		list.add(ph);
		list.add(ph1);
		Map map = CollectionMapper.extractToMap(list, "id", "path");
		Iterator i = map.keySet().iterator();
		
		while(i.hasNext()){
			System.out.println(i.next());
		}
		
		
		
	}
}
