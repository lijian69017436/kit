package design.design.mediator.demo;
//抽象中介者 类
public abstract class Mediator {
  public abstract void send(String msg,Colleague colleague);
}


class ConcreteMediator extends Mediator{
  private ConcreteColleague1 colleague1;
  private ConcreteColleague2 colleague2;

  public void setColleague1(ConcreteColleague1 colleague1) {
    this.colleague1 = colleague1;
  }
  public void setColleague2(ConcreteColleague2 colleague2) {
    this.colleague2 = colleague2;
  }

  @Override
  public void send(String msg, Colleague colleague) {
    if(colleague==colleague1){
      colleague2.Notify(msg);
    }else{
      colleague1.Notify(msg);
    }
  }
  
}


//抽象 同事类
abstract class Colleague{
  protected Mediator mediator;
  public Colleague(Mediator mediator){
    this.mediator=mediator;
  }
}
class ConcreteColleague1 extends Colleague{

  public ConcreteColleague1(Mediator mediator) {
    super(mediator);
  }
  public void send(String msg){
    mediator.send(msg, this);
  }
  public void Notify(String msg){
    System.out.println("同事1 得到消息  "+msg);
  }
}
class ConcreteColleague2 extends Colleague{
  
  public ConcreteColleague2(Mediator mediator) {
    super(mediator);
  }
  public void send(String msg){
    mediator.send(msg, this);
  }
  public void Notify(String msg){
    System.out.println("同事2 得到消息  "+msg);
  }
}


