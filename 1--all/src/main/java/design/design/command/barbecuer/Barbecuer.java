package design.design.command.barbecuer;

import org.junit.Test;

//烤肉串者   路边摊
public class Barbecuer {

 public void BakeMutton(){
    System.out.println("烤羊肉串 !");
  }
 public void BakeChickenWing(){
 System.out.println("烤鸡翅 !");
 }
 
 @Test  //客户端 程序与 烤肉串者 紧耦合,尽管简单  却极易僵化
 public void testClient(){
   Barbecuer ba = new Barbecuer();
   ba.BakeMutton();
   ba.BakeChickenWing();
   ba.BakeMutton();
   ba.BakeChickenWing();
 }
}
