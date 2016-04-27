package design.design.observer;

import org.junit.Test;

/**
 * 饮料抽象类
 * @ClassName: beverage 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author lijian 
 * @date 2016年4月27日 下午2:20:44 
 *
 */
public class beverageMain {
  @Test
  public void test1(){
    beverage b=new decaf();
    
  }
  
}


class beverage {
  private String description;
  public String getDescription() {
    return description;
  }
  public int  cost (){
    return 1;
  }
}



class decaf extends beverage{
  @Override
  public int cost() {
    return super.cost();
  }
}