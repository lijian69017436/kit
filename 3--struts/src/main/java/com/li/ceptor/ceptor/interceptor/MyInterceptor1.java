package com.li.ceptor.ceptor.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * 拦截器 是struts2 的重要组成部分
 * 防止表单重复提交
 * 文件的上传下载
 * 对象的装配，验证
 * 类型转换 等等  
 * 
 * 拦截器 可以在执行 action 之前和 action之后 拦截？
 * 拦截器针对所有 --只要是struts2中 执行的方法，都可以拦截
 * 
 * struts2 提供的实现拦截器的方式有3种 
 *        1.实现接口Interceptor    xmwork包下的
 *        
 *        
 */

public class MyInterceptor1 implements Interceptor{
/**
   * 
   */
  private static final long serialVersionUID = 1L;
  //拦截器中的 参数名称
  private String java;
  
  //当服务器 重启时 执行的 方法
  public void destroy() {
    
  }

  //当服务器第一次被启动时执行的方法 
  public void init() {
    
  }

  //拦截方法 ，每次执行的时候 ，都会被执行的方法
  /**
   * invocation : 反转的意思
   */
  public String intercept(ActionInvocation arg) throws Exception {
    System.out.println("before--------1--------"+"我是第一个拦截器--注入的第一个参数 :"+java);  
    
    
    String ss=arg.invoke();//表示拦截器的拦截方法
    
    System.out.println("after----------------1获取了拦截器的执行结果:ss="+ss);  
    return null;
  }

  public String getJava() {
    return java;
  }

  public void setJava(String java) {
    this.java = java;
  }

  
}
