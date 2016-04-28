package design.design.decorator.clothes.decorator;

public class Person {

  private String name;
  public Person() {
    // TODO Auto-generated constructor stub
  }
  public Person(String name) {
    // TODO Auto-generated constructor stub
    this.name=name;
  }
  public void show(){
    System.out.println("装扮的:"+name);
  }
}

class xiaocai extends Person{
  public xiaocai(String name) {
    // TODO Auto-generated constructor stub
  }
  @Override
  public void show() {
    // TODO Auto-generated method stub
    super.show();
  }
  
}