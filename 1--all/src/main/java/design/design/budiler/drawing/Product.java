package design.design.budiler.drawing;

import java.util.ArrayList;
import java.util.List;
/**
 * 具体的产品 
 * @author Administrator
 *
 */
public class Product{
  List<String> parts=new ArrayList<String>();
  public void Add(String part){
    parts.add(part);
  }
  public void Show(){
    System.out.println("产品   创建----");
    for(int i=0;i<parts.size();i++){
      System.out.println(parts.get(i));
    }
  }
  
  
}
