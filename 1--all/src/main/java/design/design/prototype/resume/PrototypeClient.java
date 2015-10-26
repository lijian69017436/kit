package design.design.prototype.resume;

import org.junit.Test;

/**
 * 简单原型模式
 * 原型类
 * 浅层复制 
 * @author Administrator
 *
 */
class Conre implements Cloneable{
  String id;
  public Conre(String id) {
    this.id=id;
  }
  @Override
  public Object clone()  {
      try {
        return super.clone();
      } catch (CloneNotSupportedException e) {
        e.printStackTrace();
      }
      return null;
  }
}

/**
 * 测试    原型 
 * @author Administrator
 *
 */
public class PrototypeClient{
  @Test
  public void Test1() throws CloneNotSupportedException{
    Conre con = new Conre("1");
    Conre clone = (Conre)con.clone();
    clone.id="2";
    System.out.println(clone.id);
    System.out.println(con.id);
  }
}