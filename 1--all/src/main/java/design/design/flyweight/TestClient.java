package design.design.flyweight;

import org.junit.Test;

public class TestClient {

  @Test
  public void test(){
    int extrin=22;
    FlyweightFactory f = new FlyweightFactory();
    Flyweight fx = f.getFlyweight("X");
    fx.operation(--extrin);
    Flyweight fy = f.getFlyweight("y");
    fy.operation(--extrin);
    Flyweight fz = f.getFlyweight("z");
    fz.operation(--extrin);
    
    Unshared uf = new Unshared();
    uf.operation(--extrin);
    
    
    
    
  }
}
