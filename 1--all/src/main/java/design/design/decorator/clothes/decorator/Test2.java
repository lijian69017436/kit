package design.design.decorator.clothes.decorator;

import org.junit.Test;

public class Test2 {
  @Test
  public void test(){
    Person per = new Person("小菜");
    Tshirts ts = new Tshirts();
    BigTrouser bi = new BigTrouser();
    Sock so = new Sock();
    
    ts.Decorate(per);
    bi.Decorate(ts);
    so.Decorate(bi);
    so.show();
    
    bi.Decorate(per);
    so.Decorate(bi);
    ts.Decorate(so);
    ts.show();
  }
  
}
