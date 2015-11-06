package design.design.chain_of_responsibility;

import org.junit.Test;

public class TestClient {
  @Test
  public void testClient(){
    Handler h1 = new ConcreteHandler();
    Handler h2 = new ConcreteHandler1();
    Handler h3 = new ConcreteHandler2();
    h1.setSuccessor(h2);
    h2.setSuccessor(h3);
    int [] requests={1,2,10,21,31};
    
    for(int i:requests){
      h1.handleRequest(i);
    }
  }
}
