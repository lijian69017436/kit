package design.design.state.work;

import org.junit.Test;

public class TestCilent {
  @Test
  public void Test1(){
    Work work = new Work();
    ForenoonState foren = new ForenoonState();
    work.setState(foren);
    work.setHour(1);
    work.writeProgram();
    work.setHour(10);
    work.writeProgram();
    work.setHour(14);
    work.writeProgram();
    work.setHour(18);
    work.writeProgram();
    
  }
}
