package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class I18nAction extends ActionSupport{

  public String execute() throws Exception {
    //String value=getText("welcome");//取出国际化当中的 key=号左边的名字， 
    String value=getText("welcome",new String[]{"av","nop"});//取出国际化当中的 key=号左边的名字， 
    
    ActionContext.getContext().put("message", value);
    
    
    return "s";
  }
}
