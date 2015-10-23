package design.design.factory.method;

/**
 * 工厂方法
 * @author Administrator
 *
 */
public interface IFactory { 
  
  LeiFeng CreateLeiFeng();
}


class UndergraduteFactory implements IFactory{
  @Override
  public LeiFeng CreateLeiFeng() {
    
    return new Undergraduate();
  }
}


class VolunteerFactory implements IFactory{
  @Override
  public LeiFeng CreateLeiFeng() {
    // TODO Auto-generated method stub
    return new Volunteer();
  }
}