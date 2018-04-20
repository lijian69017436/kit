package com.li.ognl.ognl.action;

public class Address {

  private String country; // 国家
  private String city;    // 城市
  private String street;  // 街道

  public Address(String country, String city, String street) {
    super();
    this.country = country;
    this.city = city;
    this.street = street;
  }
  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

}
