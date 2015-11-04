package se.se.innerClass;

/**
 */
public class OuterClass {
  private String name;
  private int    age;

  public static void main(String agrgs[]) {
    OuterClass outer = new OuterClass();
    outer.testOuter();

  }

  public void testOuter() {
    OuterClass outerClass = new OuterClass();
    outerClass.setName("外部类");
    outerClass.setAge(22);
    //内部类的 调用  可以用变量  点 直接 new 一个新的 内部类
    OuterClass.InnerClass inner = outerClass.new InnerClass();
    inner.setName("内部类");
    inner.setAge(23);
    inner.printInnerMsg(inner.getName(), inner.getAge());
  }

  class InnerClass {
    private String name;
    private int    age;

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public int getAge() {
      return age;
    }

    public void setAge(int age) {
      this.age = age;
    }
    ///在内部类 里边 可以  用  外部类  .来调用 外部类 的属性
    public void printInnerMsg(String name, int age) {
      System.out.println("  " + name + ":" + age);
      System.out.println("   " + OuterClass.this.getName() + ":" + OuterClass.this.getAge());
    }

  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }
}
