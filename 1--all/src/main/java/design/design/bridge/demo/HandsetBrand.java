package design.design.bridge.demo;
/**
 * 手机品牌  抽象类
 * @author Administrator
 *
 */
public class HandsetBrand {
  protected HandsetSoft soft;
  public void setHandsetSoft(HandsetSoft soft){
    this.soft=soft;
  }
  public void run(){
    System.out.println("");
  }
}

class HandsetBrandA extends HandsetBrand{
  @Override
  public void run() {
    // TODO Auto-generated method stub
    System.out.print("手机 a");
    soft.run();
  }
}
class HandsetBrandB extends HandsetBrand{
  @Override
  public void run() {
    // TODO Auto-generated method stub
    System.out.print("手机 b");
    soft.run();
  }
}
