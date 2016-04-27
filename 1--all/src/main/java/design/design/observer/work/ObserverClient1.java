package design.design.observer.work;

import java.util.Observable;
import java.util.Observer;

import org.junit.Test;

public class ObserverClient1 {

  @Test
  public void TestClient(){
    Boss boss = new Boss();//创建 一个 boss
    Stock stock = new Stock(); //创建 一个员工
    boss.addObserver(stock); //给 boss 条件 观察者
    boss.Notify(); //通知
    
  }
  
}

/**
 * 2个不同的 对象 
 * @author Administrator
 * 被观察者     又称通知者
 */
class Boss extends Observable{

  public void Notify(){
    setChanged();
    notifyObservers();
    setChanged();
    notifyObservers("主题对象推送的数据:123123"); //通知的数据
  }
  
}
/**
 * 观察者 
 * @author Administrator
 *
 */
class Stock implements Observer{
  @Override
/**
 * @param o 主题
 * @param arg 数据对象
 */
  public void update(Observable o, Object arg) {
    System.out.println(arg); //接受通知的数据
    // TODO Auto-generated method stub
    System.out.println("老板来了 关闭 股票");
  }
  
}