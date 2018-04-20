package ann_aop.dao;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect //
public class Security {
	/**
	 */

	@Pointcut("execution(* ann_aop.dao..*.save*(..))")
	public void PersonPointut(){
		System.out.println("person poin ----");
	}
	
  @Before("PersonPointut()&& args(username1,psw)")
  public void checkSecurity(String username1,String psw){
           System.out.println("--> check  "+username1+" "+psw);
  }

	@AfterReturning(pointcut="userManagerPointut()" ,returning="value")
	public void checkSecurity(String value){
		System.out.println("---");
	}

	@AfterThrowing(pointcut="userManagerPointut()",throwing="ex")
	public void checkSecurity(Exception ex){
		System.out.println("---"+ex.getMessage());
	}
	
	
	@After("userManagerPointut()")
	public void checkSecurity(){
		System.out.println("---");
	}
	

	
	
}
