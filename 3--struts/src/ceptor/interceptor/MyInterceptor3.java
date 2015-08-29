package interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
/**
 *  MethodFilterInterceptor 这个类叫方法过滤拦截器
 *  这个类继承了 abstractinterceptor 并提供了一中机制
 *  即可以指定 对action 中的某些方法进行拦截或者不拦截
 *  也可以自由发挥
 *  
 *  所谓的不拦截指的是拦截器当中的  dointercept（）方法是否被执行
 *  执行了 则进行拦截，没有执行 ，就没有拦截，
 *
 */
public class MyInterceptor3 extends MethodFilterInterceptor{

  protected String doIntercept(ActionInvocation ai) throws Exception {
   System.out.println("before--------------------333");
    //获取struts2 的上下文对象
    ActionContext context = ai.getInvocationContext();
    
   /**下面获取到的内容都是和这个上下文 对象 有关
        1：执行的action 类的名字，执行的方法叫什么名字 
        2：传递了什么参数 
           a参数，是从前台 到后台的参数 ，（获取前台表单中的数据）
    *      b获取从后台往前台传的 参数
    *      
    */
    String actionName=ai.getAction().getClass().toString();
    System.out.println("执行的类名称 "+actionName);
    
    String method=ai.getProxy().getMethod();
    System.out.println("执行的方法的名称"+method);
    //获取表单项传递到后台的数据 ，
    Map<String,Object> parameters=context.getParameters();
    //传递的参数 有2个，一个用户名 ，一个秘密
    //取出时按照文本框的名字获取
    String str[] =(String[]) parameters.get("userName");
    String str1[] =(String[]) parameters.get("pwd");
    System.out.println(str[0]+"  "+str1[0]);
    String re=ai.invoke();
    System.out.println("after-----------------------333 re="+re);
    return re;
  }
}
