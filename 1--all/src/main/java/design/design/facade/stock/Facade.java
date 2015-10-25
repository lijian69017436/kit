package design.design.facade.stock;

import org.junit.Test;

/**
 * 外观模式 
 * @author Administrator
 */
public class Facade {
  Stock2 sto3;
  Stock1 sto2;
  Stock sto1;
  
  public Facade() {
    // TODO Auto-generated constructor stub
    sto1 = new Stock();
    sto2 = new Stock1();
    sto3 = new Stock2();
  }
  /**
   * 基金购买
   */
  public void Buy(){
    sto1.Buy();
    sto2.Buy();
    sto3.Buy();
  }
  public void Sell(){
    sto1.Sell();
    sto2.Sell();
    sto3.Sell();
  }
  
  
  @Test
  public void TestClient(){
    Facade fac = new Facade();
    fac.Buy();
    fac.Sell();
  }
}

/**
 * 股票对象
 * @author Administrator
 *
 */
class Stock{
  public void Buy(){
    System.out.println("股票一 买入");
  }
  public void Sell(){
    System.out.println("股票一 卖出");
  }
}
class Stock1{
  public void Buy(){
    System.out.println("股票一 买入");
  }
  public void Sell(){
    System.out.println("股票一 卖出");
  }
}
class Stock2{
  public void Buy(){
    System.out.println("股票一 买入");
  }
  public void Sell(){
    System.out.println("股票一 卖出");
  }
}