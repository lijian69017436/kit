package design.design.proxys.staticProxys;


public interface GiveGift {
  void GiveDolls(); //送 娃娃
  void GiveSnacks(); //送零食
}



class Pursuit implements GiveGift{ //真实追求者
  Girl mm=null;
  public Pursuit(Girl mm) {
    this.mm=mm;
  }
  @Override
  public void GiveDolls() {
    System.out.println(mm.name+"    送你洋娃娃    ");
  }
  @Override
  public void GiveSnacks() {
    System.out.println(mm.name+"    送你 零食    ");
  }
}


class Girl {    //被追求者
   String name=null;
}


class Proxy implements GiveGift{  //代理 对象
  GiveGift pu=null;
  public Proxy(Girl mm) {
    pu=new Pursuit(mm);
  }
  public void  GiveDolls(){
    pu.GiveDolls();
  }
  @Override
  public void GiveSnacks() {
    pu.GiveSnacks();
  }
  
}