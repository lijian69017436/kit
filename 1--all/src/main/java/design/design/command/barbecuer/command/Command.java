package design.design.command.barbecuer.command;

import design.design.command.barbecuer.Barbecuer;

//抽象命令类
public abstract class Command {
  protected Barbecuer receiver;
  public Command(Barbecuer ber){
    this.receiver=ber;
  }
  
  public abstract void  excuteCommand(); 

}

//烤肉串命令 
class BackMuttonCommand extends Command{

  public BackMuttonCommand(Barbecuer ber) {
    super(ber);
  }

  @Override
  public void excuteCommand() {
    receiver.BakeMutton();
  }
}
//烤鸡腿命令 
class BackChickenWingCommand extends Command{
  public BackChickenWingCommand(Barbecuer ber) {
    super(ber);
  }
  @Override
  public void excuteCommand() {
    receiver.BakeChickenWing();
  }
}


class Waiter{
  
  private Command command;
  
  public void setOrder(Command command){
    this.command=command;
  }
  
  public void Notify(){
    command.excuteCommand();
  }
  
  
}