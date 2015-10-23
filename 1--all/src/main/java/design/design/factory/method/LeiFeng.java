package design.design.factory.method;

public class LeiFeng {//雷锋

  public void Sweep(){
    System.out.println("扫地");
  }
  public void Wash(){
    System.out.println("洗衣");
  }
  public void BuyRice   (){
    System.out.println("买 米");
  }
}

/**
 * 学雷锋的大学生
 * @author Administrator
 *
 */
class Undergraduate extends LeiFeng{
  public Undergraduate() {
    System.out.print("大学生 "); // TODO Auto-generated constructor stub
  }
}

/**
 * 社区志愿者
 * @author Administrator
 *
 */
class Volunteer extends LeiFeng{
  public Volunteer() {
   System.out.print("社区志愿者    "); // TODO Auto-generated constructor stub
  }
}