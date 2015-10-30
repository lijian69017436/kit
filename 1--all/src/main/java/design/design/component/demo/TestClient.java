package design.design.component.demo;

import org.junit.Test;

public class TestClient {
  @Test
  public void testClient(){
    Composite root = new Composite("root");
    root.add(new Leaf("leaf a"));
    root.add(new Leaf("leaf b"));
    
    Composite comp = new Composite("composite x");
    comp.add(new Leaf("leaf xa"));
    comp.add(new Leaf("leaf xb"));
    
    root.add(comp);
    
    Composite comp2 = new Composite("composite xy");
    comp2.add(new Leaf("leaf xya"));
    comp2.add(new Leaf("leaf xyb"));
    
    comp.add(comp2);
    
    root.add(new Leaf("leaf c"));
    
    Leaf leaf = new Leaf("leaf d");
    root.add(leaf);
    root.remove(leaf);
    
    root.display(1);
    
    
    
    
  }
}
