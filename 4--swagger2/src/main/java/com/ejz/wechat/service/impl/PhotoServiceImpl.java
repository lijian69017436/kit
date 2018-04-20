package com.ejz.wechat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ejz.wechat.dao.PhotoDao;
import com.ejz.wechat.dao.entity.Photo;
import com.ejz.wechat.service.PhotoService;
import com.zbxsoft.core.orm.Page;

@Service
@Transactional
public class PhotoServiceImpl implements PhotoService {
	
	@Autowired
	private PhotoDao photoDao;
	
	public PhotoServiceImpl() {
	}

	public void addPhoto(Photo photo) {
		photoDao.save(photo);
	}
	
	public Page<Photo> selectByPage(int pageNo,int pageSize){
		Page<Photo> photo = new Page<Photo>();
		photo.setPageNo(pageNo);
		photo.setPageSize(pageSize);
		Page<Photo> page = photoDao.findPage(photo);
		return page;
	}
}
