package design.design.strategy.market;

import org.junit.Test;

public class Text1 {
  @Test
  public void text(){
    CashContext cashContext = new CashContext("打八折");
    double money=cashContext.getResult(1000);
    System.out.println("需要 交费用:"+money);
  }
}
