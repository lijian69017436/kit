package se.se.innerClass;

public class OuterClass1 {

  public void printTest(String name2, int age2) {
    final String i = "admin";

   
   
    class InnerClass2 {
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

      public void printInner() {
        System.out.println(i);
      }
    }
    //在 类里边 调用 内部类
    InnerClass2 inner = new InnerClass2();
    inner.setName(name2);
    inner.setAge(age2);
    inner.printInner();
    System.out.println(inner.getName() + ":" + inner.getAge());

  }

  public static void main(String[] args) {
    OuterClass1 outer = new OuterClass1();
    outer.printTest("111", 222);
  }

}
