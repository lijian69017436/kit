package design.design.state.overtime;

import org.junit.Test;

public class TestClient {
@Test
public void Test1(){
  Context c = new Context(new ConcreteStateA());
  c.Request();
  c.Request();
  c.Request();
  
}
}
