package com.li.ceptor.ceptor.action;

import com.li.base.BaseAction;

public class Action extends BaseAction{
	private static final long serialVersionUID = 1L;
	
	//默认执行的 action
	public String execute() throws Exception {
		System.out.println("执行");
		
		return SUCCESS;
	}
	public String act(){
	  System.out.println(req.getRequestURL());
	  return "success";
	}
	
	
}
