package com.ejz.wechat.service;

import com.ejz.wechat.dao.entity.Photo;
import com.zbxsoft.core.orm.Page;

public interface PhotoService {

	public void addPhoto(Photo photo);
	
	public Page<Photo> selectByPage(int pageNo,int pageSize);
	
}
