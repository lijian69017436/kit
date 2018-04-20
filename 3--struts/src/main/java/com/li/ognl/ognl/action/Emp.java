package com.li.ognl.ognl.action;

import java.util.Map;

public class Emp {
  private String name;
  private int age;
  private float sal;
  private Address address;
  private String[] emails;
  private Map<String,String> accounts;
  
  
  
  public Emp(String name, int age, float sal, Address address, String[] emails,
      Map<String, String> accounts) {
    super();
    this.name = name;
    this.age = age;
    this.sal = sal;
    this.address = address;
    this.emails = emails;
    this.accounts = accounts;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getAge() {
    return age;
  }
  public void setAge(int age) {
    this.age = age;
  }
  public float getSal() {
    return sal;
  }
  public void setSal(float sal) {
    this.sal = sal;
  }
  public Address getAddress() {
    return address;
  }
  public void setAddress(Address address) {
    this.address = address;
  }
  public String[] getEmails() {
    return emails;
  }
  public void setEmails(String[] emails) {
    this.emails = emails;
  }
  public Map<String, String> getAccounts() {
    return accounts;
  }
  public void setAccounts(Map<String, String> accounts) {
    this.accounts = accounts;
  }
  
  
}
