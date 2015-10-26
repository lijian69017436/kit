package design.design.state.work;

public class Work {
  private int hour;
  private IState state;

  
  public void writeProgram(){
    state.WriteProgram(this);
  }
  
  public void setState(IState state) {
    this.state = state;
  }
  public IState getState() {
    return state;
  }

  public void setHour(int hour) {
    this.hour = hour;
  }
  public int getHour() {
    return hour;
  }
}
