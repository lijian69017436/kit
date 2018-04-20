package com.ejz.wechat.daoTest;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ejz.wechat.dao.StaffDao;
import com.ejz.wechat.dao.entity.Staff;
import com.ejz.wechat.util.DateUtils;
import com.zbxsoft.core.orm.Page;

public class StaffDaoTest extends SpringJunitTest{

	@Autowired
	StaffDao staffTest;
	
	
	@Test
	public void dd(){
		Page<Staff> page = (Page<Staff>) staffTest.queryStaffByBrithday("2016-10-11 02:28:53");
		List<Staff> list =  page.getResult();
		
		for(Staff s:list){
			System.out.println(s.getName());
		}
	}
	
	@Test
	public void ddd(){
		String s = DateUtils.formatDate_ymdhms(new Date());
		System.out.println(s);
	}
	
}
