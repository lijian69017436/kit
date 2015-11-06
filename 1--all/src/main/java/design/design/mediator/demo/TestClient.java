package design.design.mediator.demo;

import org.junit.Test;

public class TestClient {

  @Test
  public void testClient(){
    
    ConcreteMediator m = new ConcreteMediator();
    //让2个同事认识中介者
    ConcreteColleague1 c1 = new ConcreteColleague1(m);
    ConcreteColleague2 c2 = new ConcreteColleague2(m);
    
    //让中介者 认识 各个同事
    m.setColleague1(c1);
    m.setColleague2(c2);
    
    //具体同事对象 发送消息都 通过中介者 转发
    c1.send("吃过饭了麻 ?");
    c2.send("没有呢,你打算请客?");
    
  }
}
