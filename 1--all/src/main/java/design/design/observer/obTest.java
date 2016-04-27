package design.design.observer;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * 观察者模式
 * @ClassName: obTest 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author lijian 
 * @date 2016年4月26日 下午5:02:47 
 *
 */
public class obTest { //主题对象
  @Test
  public void tests(){
    aImpl aImpl = new aImpl();

    bImpl bImpl = new bImpl();
    cImpl cImpl = new cImpl();
    aImpl.addList(bImpl);
    aImpl.addList(cImpl);
    
    aImpl.update();
  }
  
}
class aTest{
  private List<bTest> list=new ArrayList<>();
  public void addList(bTest e){
    list.add(e);
  }
  public void delList(bTest e){
    list.remove(e);
  }
  public void update(){
    for(bTest o:list){
      o.tongzhi();
    }
  }
}


class bTest{
  public void tongzhi(){
    System.out.println("2");
  }
}


class aImpl extends aTest{
  
}

class bImpl extends bTest{
  
}
class cImpl extends bTest{
  
}
