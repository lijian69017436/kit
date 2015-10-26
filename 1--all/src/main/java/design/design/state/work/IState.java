package design.design.state.work;

public interface IState {
  public void WriteProgram(Work w);
}


class ForenoonState implements IState{
  @Override
  public void WriteProgram(Work w) {
    // TODO Auto-generated method stub
   if(w.getHour()<12){
     System.out.println("当前时间:"+w.getHour()+"点 上午工作,精神百倍");
   }else{
     w.setState(new NoonState());
     w.writeProgram();
   }
  }
}
class NoonState implements IState{
  @Override
  public void WriteProgram(Work w) {
    // TODO Auto-generated method stub
    if(w.getHour()<13){
      System.out.println("当前时间:"+w.getHour()+"点    饿了,午饭:午休");
    }else{
      w.setState(new AfternoonState());
      w.writeProgram();
    }
  }
}
class AfternoonState implements IState{
  @Override
  public void WriteProgram(Work w) {
    // TODO Auto-generated method stub
    if(w.getHour()<17){
      System.out.println("当前时间:"+w.getHour()+"点    下午状态还不错 继续努力");
    }else{
      System.out.println("下班啦");
    }
  }
}
