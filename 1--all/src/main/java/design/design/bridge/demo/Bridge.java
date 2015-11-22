package design.design.bridge.demo;

import org.junit.Test;

public class Bridge {
  @Test
  public void testClient(){
    HandsetBrand brand=null;
    brand=new HandsetBrandA();
    brand.setHandsetSoft(new HandsetGame());
    brand.run();
    brand.setHandsetSoft(new HandsetAdress());
    brand.run();
    
    brand =new HandsetBrandB();
    brand.setHandsetSoft(new HandsetGame());
    brand.run();
    brand.setHandsetSoft(new HandsetAdress());
    brand.run();
    
  }
}
