package design.design.state.overtime;

import org.junit.Test;

public class TestClient {
  @Test
  public void Test1() {
    Context c = new Context();
    c.setState(new ConcreteStateA());//设置 初始化状态
    c.Request(); //请求一次  在逻辑里边  设置 下一个状态
    c.Request(); //在请求一次  继续 循环设置状态

  }
}
