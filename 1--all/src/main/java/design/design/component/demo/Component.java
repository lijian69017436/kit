package design.design.component.demo;

import java.util.ArrayList;
import java.util.List;

public abstract   class Component {
  protected String name;
  public Component(String name){
    this.name=name;
    
  }
  public abstract void add(Component c);
  public abstract void remove(Component c);
  public abstract void display(int depth);
}

class Leaf extends Component{
  public Leaf(String name){
    super(name);
  }

  @Override
  public void add(Component c) {
    // TODO Auto-generated method stub
    System.out.println("cannot add to aleaf ");
  }

  @Override
  public void remove(Component c) {
    // TODO Auto-generated method stub
    System.out.println("cannot remove from a leaf");
  }

  @Override
  public void display(int depth) {
    // TODO Auto-generated method stub
    StringBuffer s=new StringBuffer();
    for(int i=0;i<depth;i++){
      s.append("-");
    }
    System.out.println(s.toString()+name);
  }
  
}

class Composite extends Component{
  private List<Component> children=new ArrayList<Component>();
  public Composite(String name) {
    super(name);
    // TODO Auto-generated constructor stub
  }

  @Override
  public void add(Component c) {
    // TODO Auto-generated method stub
    children.add(c);
  }

  @Override
  public void remove(Component c) {
    // TODO Auto-generated method stub
    children.remove(c);
  }

  @Override
  public void display(int depth) {
    // TODO Auto-generated method stub
    StringBuffer s=new StringBuffer();
    for(int i=0;i<depth;i++){
      s.append("-");
    }
    System.out.println(s.toString()+name);
    for(Component d:children){
      d.display(depth+3);
    }
  }
  
}