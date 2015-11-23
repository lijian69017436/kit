package com.li.ognl.ognl.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class OgnlAction extends ActionSupport 
implements ParameterAware,RequestAware,SessionAware,ApplicationAware{
  //对应 参数 来进行拦截的  拦截器   struts2 自带的
	private static final long serialVersionUID = 1L;
	private String userName;
	private String pwd;
	private Map parameters;
	private Map request;
	private Map session;
	private Map application;
	private List<Emp> emps=new ArrayList<Emp>();
	
	


  /**
	 * 当 action 中 提供属性的set ，get方法后，我们可以再页面上获取属性的值
	 * 原因：struts2提供了2中存储数据的方式
	 *   值栈
	 *     直接从栈内获取数据
	 *     list的操作
	 *   非值栈
	 *     下列操作在获取数据的时候，必须以# 
	 * @return
	 */
	public void initEmp(){
	  Address a1=new Address("北京","北京","中关村");
	  Address a2=new Address("北京","上海","虹桥");
	  Address a3=new Address("中国","山东","xx");
	  String [] emails1 =new String []{"123@qq.com","456.qq.com"};
	  String [] emails2 =new String []{"ffsdfa@qq.com","456@163.com"};
	  String [] emails3 =new String []{"1hgf@qq.com","456@qq.com"};
	  Map<String,String> accounts=new HashMap<String,String>();
	  accounts.put("建设", "dsaf");
	  Map<String,String> accounts1=new HashMap<String,String>();
	  accounts.put("广大", "李健");
	  Map<String,String> accounts2=new HashMap<String,String>();
	  accounts.put("中心", "丁丁");
	  Emp emp1=new Emp("张三",30,1009,a1,emails1,accounts);
	  Emp emp2=new Emp("张三",30,1009,a2,emails1,accounts1);
	  Emp emp3=new Emp("张三",30,1009,a3,emails1,accounts2);
	  emps.add(emp1);
	  emps.add(emp2);
	  emps.add(emp3);
	  
	}
	public String login(){
	    initEmp();
      parameters.put("greeting", "欢迎");
      request.put("empName", emps.get(0).getName());
      session.put("empName", emps.get(1).getName());
      application.put("empName", emps.get(2).getName());
      session.put("list", emps);
      addFieldError("oo", "ddff");
      return "success";
	}

	
	
	public List<Emp> getEmps() {
    return emps;
  }
  public void setParameters(Map parameters) {
    this.parameters = parameters;
  }
  public void setRequest(Map request) {
    this.request = request;
  }
  public void setSession(Map session) {
    this.session = session;
  }
  public void setApplication(Map application) {
    this.application = application;
  }
	
  public String getUserName() {
    return userName;
  }
  public void setUserName(String userName) {
    this.userName = userName;
  }
  public String getPwd() {
    return pwd;
  }
  public void setPwd(String pwd) {
    this.pwd = pwd;
  }
	
}
