package interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
/**
 * 实现的这个拦截器，是抽象类，这个抽象类实现了interceptor 接口
 *并且 对里面 的init 方法和 distory方法 进行了空 实现 
 *而把intercept（）方法设置为 抽象方法 
 *比 第一个实现 interceptor 接口简单一些
 */
public class MyInterceptor2 extends AbstractInterceptor{

  public String intercept(ActionInvocation ai) throws Exception {
    System.out.println("before------------222");
    String tt=ai.invoke();
    
    
    System.out.println("after------------222执行结果是 tt="+tt);
    return null;
  }

}
