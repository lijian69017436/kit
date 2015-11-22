package design.design.command.barbecuer.command;

import org.junit.Test;

import design.design.command.barbecuer.Barbecuer;

public class Client {
@Test
  public void testClient(){
    //开店前的准备 
    Barbecuer boy = new Barbecuer(); //烤肉师傅
    Command mutoon = new BackMuttonCommand(boy); //菜单
    Command mutoon1 = new BackMuttonCommand(boy); 
    Command chicken = new BackChickenWingCommand(boy);
    //开门营业
    Waiter girl = new Waiter(); 
    girl.setOrder(mutoon);
    girl.Notify();
    girl.setOrder(mutoon1);
    girl.Notify();
    girl.setOrder(chicken);
    girl.Notify();
    
    
    
  }
  
}
