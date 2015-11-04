package se.se.exception;

public class ExceptionTest {
  public Boolean setAgeArrea(int age) throws Exception {
    boolean flag = false;
    if (age > 18 && age <= 100) {

      flag = true;
    } else{
      throw new Exception("18-100");
    }
    System.out.println("********");
    return flag;
  }

  public static void main(String args[]) {
    ExceptionTest test = new ExceptionTest();
    Boolean b = null;
    try{
      b = test.setAgeArrea(6);
      System.out.println(b);

    } catch (Exception e){
      e.printStackTrace();
    } finally{
      System.out.println("===");

    }
    System.out.println("----");

  }
}
