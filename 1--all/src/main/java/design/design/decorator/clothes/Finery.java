package design.design.decorator.clothes;

public abstract class Finery {
  public abstract void show();
}




class TShirts extends Finery{
  @Override
  public void show() {
    // TODO Auto-generated method stub
   System.out.print("大T桖    "); 
  }
}



class BigTrouser extends Finery{
  public void show(){
    System.out.print("垮裤    ");
  }
}


class Oldshoes extends Finery{
  public void show(){
    System.out.print("老头鞋     ");
  }
}


class Underpants extends Finery{
  public void show(){
    System.out.print("裤衩    ");
  }
}




