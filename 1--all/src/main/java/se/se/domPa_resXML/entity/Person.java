package se.se.domPa_resXML.entity;

public class Person {
  private String  cardno;
  private String  name;
  private Integer age;
  private String  address;
  private String  birthday;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getBirthday() {
    return birthday;
  }

  public void setBirthday(String birthday) {
    this.birthday = birthday;
  }

  public String getCardno() {
    return cardno;
  }

  public void setCardno(String cardno) {
    this.cardno = cardno;
  }

}
