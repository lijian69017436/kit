package design.design.decorator.clothes;

import org.junit.Test;

public class test1 {
  @Test
  public void test1(){
    Person person = new Person("小菜");
    Underpants un = new Underpants();
    BigTrouser bigT = new BigTrouser();
    TShirts tSh = new TShirts();
    Oldshoes olds = new Oldshoes();
    un.show();
    bigT.show();
    tSh.show();
    olds.show();
    person.show();
  }
}
