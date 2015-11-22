package design.design.chain_of_responsibility;

/**
 * 职责链模式
 * @author Administrator
 *
 */
public abstract class Handler {
  
  protected Handler successor;
  //设置继任者
  public void setSuccessor(Handler successor){
    this.successor=successor;
  }
  
  public abstract void handleRequest(int request);
}

class ConcreteHandler extends Handler{
  @Override
  public void handleRequest(int request) {
    if(request>=0 && request<10){
      System.out.println("处理请求"+this.getClass().getName()+"---"+request);
    }else if(successor !=null){
      successor.handleRequest(request);
    }
  }
}
class ConcreteHandler1 extends Handler{
  @Override
  public void handleRequest(int request) {
    if(request>=10 && request<20){
      System.out.println("处理请求"+this.getClass().getName()+"---"+request);
    }else if(successor !=null){
      successor.handleRequest(request);
    }
  }
}
class ConcreteHandler2 extends Handler{
  @Override
  public void handleRequest(int request) {
    if(request>=20 && request<30){
      System.out.println("处理请求"+this.getClass().getName()+"---"+request);
    }else if(successor !=null){
      successor.handleRequest(request);
    }
  }
}

