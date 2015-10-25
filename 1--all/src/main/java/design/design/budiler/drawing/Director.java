package design.design.budiler.drawing;
/**
 * @author Administrator
 * 把产品 按照顺序组装
 */
public class Director {
  
  public void Construct(Builder buil){
    buil.BuidPartA();
    buil.BuidPartB();
  }
  
}
