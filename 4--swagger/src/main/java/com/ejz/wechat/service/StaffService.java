package com.ejz.wechat.service;

import java.util.List;

import com.ejz.wechat.dao.entity.Photo;
import com.ejz.wechat.dao.entity.Staff;
import com.zbxsoft.core.orm.Page;

public interface StaffService {

	public List<Staff> queryStaffBytime(String time);
}
