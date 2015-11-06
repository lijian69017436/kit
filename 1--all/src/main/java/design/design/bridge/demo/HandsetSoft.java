package design.design.bridge.demo;
/**
 * 手机软件抽象类
 * @author Administrator
 *
 */
public class HandsetSoft {
 public void run(){
   
 }
}
//手机游戏
class HandsetGame extends HandsetSoft{
@Override
public void run() {
  System.out.println("运行手机游戏 ");
    super.run();
}

}
//手机通讯录
class HandsetAdress extends HandsetSoft{
@Override
public void run() {
  System.out.println("运行手机通讯录 ");
  super.run();
}

}