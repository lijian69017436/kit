package design.design.observer.work;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
public class ObserverClient{
  @Test
  public void TestClient(){
    Secretary tongzizhe = new Secretary();//前台 mm
    StockObserver tongshi1 = new StockObserver("魏关茬", tongzizhe);//看股票的同事
    StockObserver tongshi2 = new StockObserver("易观查", tongzizhe);
    
    tongzizhe.Attach(tongshi1);//前台  记下了2位同事
    tongzizhe.Attach(tongshi2);
    
    tongzizhe.setSecretaryAction("老板回来了");
    tongzizhe.Notify();//前台美眉 通知 同事 老板回来了
  }
}
/**
 * 同事  对象
 * @author Administrator
 *
 */
class StockObserver {

  private String name;
  private Secretary sub; //秘书
  
  public StockObserver(String name,Secretary sub){
    this.name=name;
    this.sub=sub;
  }
  public void Update (){
    System.out.println(sub.SecretaryAction+name+"关闭 股票 行情,继续工作");
  }
}
/**
 * 前台秘书对象
 * @author Administrator
 *
 */
class Secretary{
  private List<StockObserver> observers=new ArrayList<StockObserver> ();
  public String SecretaryAction;
  public void Attach(StockObserver observer){
    observers.add(observer);
  }
  public void Notify(){
    for(StockObserver o:observers){
      o.Update();
    }
  }
  public String getSecretaryAction() {
    return SecretaryAction;
  }
  public void setSecretaryAction(String secretaryAction) {
    SecretaryAction = secretaryAction;
  }
}