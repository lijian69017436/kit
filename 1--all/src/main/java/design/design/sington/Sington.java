package design.design.sington;

public class Sington {// 懒汉 模式    在对象调用的时候在 创建
 
  private static Sington sin = null;
  private Sington() {

  }
  public static Sington getInstance() {
    if (sin == null) {
      sin = new Sington();
    }
    return sin;
  }
}


class Sington1 {// 饿汉模式    在类初始化 的时候就 加载  创建
  private static Sington1 sin = new Sington1();
  private Sington1() {

  }
  public static Sington1 getInstance() {
    return sin;
  }
}
