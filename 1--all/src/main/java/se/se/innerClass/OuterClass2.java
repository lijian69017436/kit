package se.se.innerClass;

public class OuterClass2 {
  //内部 接口
  interface InnerDao {
    public void printMsg();
  }
  
  
  public static void main(String[] args) {
    //创建一个内部接口   必须有实现
    InnerDao dao = new InnerDao() {
      public void printMsg() {
        System.out.println("--");

      }
    };

    dao.printMsg();
  }
  

}
