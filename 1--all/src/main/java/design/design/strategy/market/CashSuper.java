package design.design.strategy.market;

public abstract class CashSuper {//收费 算法
  public abstract double acceptCash(double money);
}


class CashNormal extends CashSuper{//正常收费 
  @Override
  public double acceptCash(double money) {
    return money;
  }
  
}

class CashRebate extends CashSuper{//打折收费
  private String rebate="";
  public CashRebate(String rebate) { //初始化时候传入打折  折扣
    this.rebate=rebate;
  }
  @Override
  public double acceptCash(double money) {
    return money*(Double.valueOf(rebate));
  }
}

class CashActivity extends CashSuper{//活动收费
  private double moneyCondition;
  private double moneyReturn;
  public CashActivity(double moneyCondition,double moneyReturn ) {
    this.moneyCondition=moneyCondition;
    this.moneyReturn=moneyReturn;
  }
  @Override
  public double acceptCash(double money) {
    if(money>=moneyCondition){
      money=money-Math.floor((money/moneyCondition))*moneyReturn;
    }
    return money;
  }
}
