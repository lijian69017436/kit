package com.li.li;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zbxsoft.core.orm.hibernate.ZbxBaseDao;

@Repository
@Transactional
public class PhotoDao extends ZbxBaseDao<Photo, String> {

	@Override
	public void save(Photo entity) {
		getSession().save(entity);
		System.out.println("数据库___" + entity.getPath());
	}
	
	

}
