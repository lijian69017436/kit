package design.design.proxys.staticProxys;

import org.junit.Test;

public class Test1 {
  @Test
  public void test1(){
    Girl girl = new Girl();  //被追求对象
    girl.name="李娇娇";
    
    Proxy zhangsan=new Proxy(girl); //代理 对象  
    zhangsan.GiveDolls(); 
    zhangsan.GiveSnacks();
  
  
  }
}
