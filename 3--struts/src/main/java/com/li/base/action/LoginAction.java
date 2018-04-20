package com.li.base.action;

import com.li.base.BaseAction;

public class LoginAction extends BaseAction{
  private static final long serialVersionUID = 1L;

  public String execute() throws Exception {
    System.out.println("执行");
    
    return "登陆";//返回视图
  }
}
