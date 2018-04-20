package com.ejz.wechat.dao;

import java.util.Date;

import org.junit.Test;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ejz.wechat.dao.entity.Staff;
import com.ejz.wechat.util.DateUtils;
import com.zbxsoft.core.orm.Page;
import com.zbxsoft.core.orm.hibernate.ZbxBaseDao;


@Repository
@Transactional
public class StaffDao extends ZbxBaseDao<Staff, String>{

	public Page<?> queryStaffByBrithday(String time){
		StringBuffer sql = new StringBuffer();
		sql.append(" select * from staff s ");
		sql.append("   where  (SELECT MONTH(s.birthday))= '" +DateUtils.formateString_format(time,"MM") +"'");
		
		Page<?> result = this.getPageListBySql(sql.toString(), 100, 1, Staff.class);
		return result;
	}
	
  
	@Test
	public void dd(){
		String date = DateUtils.formatDate_ymdhms(new Date());
		System.out.println(date);
	}
}
