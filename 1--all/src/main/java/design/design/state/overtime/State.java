package design.design.state.overtime;

public abstract class State {
  public abstract void Handle(Context context);
}

class ConcreteStateA extends State{
  public void Handle(Context context) {
   System.out.println(String.format("加班到:%s点 ,精神呗好", "9"));
   context.setState(new ConcreteStateB()); 
  }
}
class ConcreteStateB extends State{
  public void Handle(Context context) {
    System.out.println(String.format("加班到:%s点 ,精神呗好", "10"));
    context.setState(new ConcreteStateA()); 
  }
}



class Context{
  private State state;
  public Context(State state){
    this.state=state;
  }
  public void setState(State state) {
    this.state = state;
  }

  public void Request(){
    state.Handle(this);
  }
}