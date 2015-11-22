package com.li.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.inject.Container;

import net.sf.json.JSONObject;

/**
 * ajax  提交 返回 都是 这个 
 * 
 * 所有  servlet 继承这个 类  规范 返回信息 
 * 返回 json 串   
 * 
 * 前台 提交 内容
 *  $.ajax( {
        url : '/sellgold/gold-sales!getWaringValue.action?prodType=T&d='+new Date().getTime(),
        success : function(data) {
          var result = jQuery.parseJSON(data); //jquery 解析 json串
            if(result.isok=='T'){
              
            }else{
              ZBXTools.disableButton("#addid");
              $.messager.alert('提示', result.msg, 'info');
            }
        }
      });
 *
 */
public class BaseAction extends ActionSupport {
  HttpServletResponse resp ;
  HttpServletRequest req;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
  @Override
  public void addActionMessage(String aMessage) {
    // TODO Auto-generated method stub
    System.out.println(1);
    super.addActionMessage(aMessage);
  }
  @Override
  public void setContainer(Container container) {
    resp= ServletActionContext.getResponse();
    req = ServletActionContext.getRequest();
    System.out.println(req.getRequestURI()+"----"+JSONObject.fromObject(req.getParameterMap()));
    super.setContainer(container);
  }
  
	/*
	 * 返回结果值
	 */
	protected void showOk(Object msg) throws Exception {
	  
	  req.getSession().getAttribute("loginuser");
	  
		JSONObject jvo = new JSONObject();
		jvo.put("isok", "T");
		jvo.put("msg", msg);
		
		resp.setContentType("text/html;charset=UTF-8");
		resp.getWriter().write(jvo.toString());

	}

	

}
