package design.design.decorator.clothes.decorator;

public class Finery extends Person{

  private Person componet;
  public void Decorate(Person componet){
    this.componet=componet;
  }
  @Override
  public void show(){
    if(componet!=null){
      componet.show();
    }
  }
}

class Tshirts extends Finery{
  @Override
  public void show() {
    // TODO Auto-generated method stub
   System.out.print("大T桖   ");
    super.show();
  }
}

class BigTrouser extends Finery{
  @Override
  public void show() {
    System.out.print("垮裤   ");
    super.show();
  }
}

class Sock extends Finery{
  @Override
  public void show() {
    System.out.print("拖鞋    ");
    super.show();
  }
}
