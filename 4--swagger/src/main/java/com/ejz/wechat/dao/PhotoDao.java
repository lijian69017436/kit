package com.ejz.wechat.dao;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.ejz.wechat.dao.entity.Photo;
import com.zbxsoft.core.orm.hibernate.ZbxBaseDao;


@Repository
public class PhotoDao extends ZbxBaseDao<Photo, String>{

	@Override
	public void save(Photo entity) {
		// TODO Auto-generated method stub
		Serializable save = getSession().save(entity);
		System.out.println("数据库___"+entity.getPath());
		
		//super.save(entity);
	}
  
}
