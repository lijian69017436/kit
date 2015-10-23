package design.design.factory.method;

import org.junit.Test;

/**
 * 工厂方法调用
 * @author Administrator
 *
 */
public class TestLeiFengClient {
  @Test 
  public void Client (){
   LeiFeng under= new UndergraduteFactory().CreateLeiFeng();
   under.Wash();
   
   LeiFeng volun = new VolunteerFactory().CreateLeiFeng();
   volun.BuyRice();
  }
}
