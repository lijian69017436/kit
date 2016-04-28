package design.design.decorator.clothes.decorator2;

import org.junit.Test;
/**
 * 装饰模式
 * @ClassName: drink 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author lijian 
 * @date 2016年4月28日 下午3:47:11 
 *
 */
public class drink {
  @Test
  public void test_1(){
    drink drink1 = new drink1();
    drink1=new drink2_1(drink1);
    drink1=new drink2_2(drink1);
    drink1.cost();
  }
  
  public void cost(){
    System.out.println("cost 1");
  }
}

class drink1 extends drink{
  @Override
  public void cost() {
    System.out.println("cost 2");
  }
}

class drink2 extends drink{
  @Override
  public void cost() {
    System.out.println("cost 3");
  }
}


class drink2_1 extends drink2{
  private drink di;
  public drink2_1(drink di) {
    this.di=di;
  }
  @Override
  public void cost() {
    System.out.println("cost 4");
    di.cost();
  }
}

class drink2_2 extends drink2{
  private drink di;
  public drink2_2(drink di) {
    this.di=di;
  }
  @Override
  public void cost() {
    System.out.println("cost 5");
    di.cost();
  }
}