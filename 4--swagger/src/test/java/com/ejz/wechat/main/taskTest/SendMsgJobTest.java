package com.ejz.wechat.main.taskTest;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SendMsgJobTest {

	@Test
	public void dd(){
		
		ApplicationContext act=new ClassPathXmlApplicationContext("classpath:application-context.xml");
		
//		SendMsgJob bean = (SendMsgJob) act.getBean("sendMsgJob");
//		try {
//			
//			bean.sendMsgAll();
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
		
	}
	
}
