package com.ejz.wechat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejz.wechat.dao.StaffDao;
import com.ejz.wechat.dao.entity.Photo;
import com.ejz.wechat.dao.entity.Staff;
import com.ejz.wechat.service.StaffService;
import com.zbxsoft.core.orm.Page;

@Service
public class StaffServiceImpl implements StaffService {

	@Autowired 
	StaffDao staffDao;
	
	
	public List<Staff> queryStaffBytime(String time) {
	
		return  (List<Staff>) staffDao.queryStaffByBrithday(time ).getResult();
	}

}
