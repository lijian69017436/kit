
package com.li.I18n.I18n;

import com.li.base.BaseAction;
import com.opensymphony.xwork2.ActionContext;

public class I18nAction extends BaseAction{
  private static final long serialVersionUID = 1L;

  
  public String execute() throws Exception {
    //String value=getText("welcome");//取出国际化当中的 key=号左边的名字， 
    String value=getText("welcome",new String[]{"av","nop"});//取出国际化当中的 key=号左边的名字， 
    
    ActionContext.getContext().put("message", value);
    
    
    return "s";
  }
}
