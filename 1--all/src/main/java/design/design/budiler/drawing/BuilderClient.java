package design.design.budiler.drawing;

import org.junit.Test;

public class BuilderClient {

  @Test
  public void TestClient(){
    Builder b1 = new ConcreteBuilder1(); //
    Builder b2 = new ConcreteBuilder2();
    
    Director dir = new Director();
    
    dir.Construct(b1);//把产品   部件   按照 顺序 组装 成产品
    Product p1=b1.GetResult(); //得到 产品 
    p1.Show();
    
    dir.Construct(b2);
    Product p2 = b2.GetResult();
    p2.Show();
    
  }
}
