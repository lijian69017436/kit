package action;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
  private static final long serialVersionUID = 1L;

  public String execute() throws Exception {
    System.out.println("执行");
    
    return "登陆";//返回视图
  }
}
