package com.ejz.wechat.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * 基础类
 */
@Controller
public class BaseController {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	protected HttpServletRequest request;
	
	protected HttpServletResponse response;

	
	  @ModelAttribute
	  public void setReqAndRes(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
	    // 多线程下 设置 线程 局部变量

	    this.request = request;
	    this.response = response;
	  }
}
