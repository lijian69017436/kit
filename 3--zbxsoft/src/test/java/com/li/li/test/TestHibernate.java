package com.li.li.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.junit.Test;

import com.li.li.Photo;
import com.li.li.PhotoDao;
import com.li.li.jdbc.HibernateSessionFactory;
import com.zbxsoft.core.orm.Page;
import com.zbxsoft.core.utils.IdUtils;
import com.zbxsoft.core.utils.PropertiesUtils;

public class TestHibernate {

	@Test
	public void testHibernate() {
		SessionFactory sf = HibernateSessionFactory.getSessionFactory();
		PhotoDao phdao = new PhotoDao();
		phdao.setSessionFactory(sf);
		
		List<Photo> all = phdao.getAll();
		System.out.println(all.size());
		Photo d = phdao.findUniqueBy("id", "b1dab86f-8c8a-4ce8-a6cf-cca0336b9eff");
		System.out.println(d.getPath());
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ii", "1");
		List<Object> find = phdao.find("select p.id from Photo p where  p.id=:ii",map);
		System.out.println(find.size());
		
		String idName = phdao.getIdName();
		System.out.println(idName);
		
		
		Query createQuery = phdao.createQuery("select p.id from Photo p where p.id=:ii", map);
		List list = createQuery.list();
		System.out.println(list.size());
	}
	@Test
	public void dd() throws IOException{
		System.out.println(IdUtils.uuid());
		System.out.println(IdUtils.randomBase62());
		System.out.println(IdUtils.randomLong());
		PropertiesUtils.loadProperties(new String[]{""});
	}

	
	
	
}
