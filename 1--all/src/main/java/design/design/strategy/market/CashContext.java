package design.design.strategy.market;

public class CashContext {
  CashSuper cashSuper;
  
  public CashContext(String cash) {
    switch (cash) {
      case "正常" :
        cashSuper=new CashNormal();
        break;
      case "打八折" :
        cashSuper=new CashRebate("0.8");
        break;
      case "满200反100" :
        cashSuper=new CashActivity(200,100);
        break;
      case "满300反200" :
        cashSuper=new CashActivity(300,200);
        break;
      default:
        cashSuper=new CashNormal();
        break;
    }
    
  }
  
  
  public double getResult(double money){// 传入 money  返回 结算后的money
    return cashSuper.acceptCash(money);
  }
}
