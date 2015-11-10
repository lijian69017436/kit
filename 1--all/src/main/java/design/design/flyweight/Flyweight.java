package design.design.flyweight;

import java.util.Hashtable;

public abstract class Flyweight {

  public abstract void operation(int extrinsicstate);
}

class ConcreteFlyweight extends Flyweight{

  @Override
  public void operation(int extrinsicstate) {
    // TODO Auto-generated method stub
    System.out.println("具体  flyweight :" +extrinsicstate);
  }
  
}

class Unshared extends Flyweight{

  @Override
  public void operation(int extrinsicstate) {
    // TODO Auto-generated method stub
    System.out.println("不共享的具体 flyweight :"+extrinsicstate);
  }
  
}

class FlyweightFactory{
  private Hashtable flyweights=new Hashtable();
  public FlyweightFactory(){
    flyweights.put("X", new ConcreteFlyweight());
    flyweights.put("y", new ConcreteFlyweight());
    flyweights.put("z", new ConcreteFlyweight());
  }
  public Flyweight getFlyweight(String key){
    return (Flyweight) flyweights.get(key);
  }
}

