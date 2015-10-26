package design.design.state.overtime;
/** context 设置状态 
 *  
 * 在 request 中 调用 状态的 一个方法 
 *   传入  当前对象
 * 然后在状态中  在用传入的 对象 设置状态  
 * 下次在请求的 时候  context 里边状态就改变了 
 *  
 * @author Administrator
 *
 */
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

  public void setState(State state) {
    this.state = state;
  }

  public void Request(){
    state.Handle(this);
  }
}