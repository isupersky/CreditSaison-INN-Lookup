package com.example.CreditSaisonINNLookup.entity;

public class Bank {

  public String name;
  public String url;
  public String phone;
  public String city;

  public String getName() {
    return name;
  }

  public Bank setName(String name) {
    this.name = name;
    return this;
  }

  public String getUrl() {
    return url;
  }

  public Bank setUrl(String url) {
    this.url = url;
    return this;
  }

  public String getPhone() {
    return phone;
  }

  public Bank setPhone(String phone) {
    this.phone = phone;
    return this;
  }

  public String getCity() {
    return city;
  }

  public Bank setCity(String city) {
    this.city = city;
    return this;
  }

  @Override
  public String toString() {
    return "Bank{" +
        "name='" + name + '\'' +
        ", url='" + url + '\'' +
        ", phone='" + phone + '\'' +
        ", city='" + city + '\'' +
        '}';
  }
}
