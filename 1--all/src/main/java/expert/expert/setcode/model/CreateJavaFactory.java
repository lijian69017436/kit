package expert.expert.setcode.model;

import java.io.IOException;
import java.net.URISyntaxException;

public class CreateJavaFactory {

  public void CreateJava(String type) {
    try {
      
      switch (type) {
        case "dao" :
          new CreateDao().CreateJava();
          break;
        case "bean" :
          new CreateBean().CreateJava();
          break;
        case "service" :
          new CreateService().CreateJava();
          break;
        default :
          System.out.println("type not find");
          break;
      }
      
      
    } catch (IOException e) {
      e.printStackTrace();
    } catch (URISyntaxException e) {
      e.printStackTrace();
    }
  }
}
