package expert.expert.setcode;

import expert.expert.setcode.model.CreateJavaFactory;

public class MainMethod {
  
  public static void main(String[] args) {
    CreateJavaFactory fac = new CreateJavaFactory();
    try{
      fac.CreateJava("dao");
      fac.CreateJava("bean");
      fac.CreateJava("service");
      
    } catch (Exception e){
      e.printStackTrace();
    }
  }
}
