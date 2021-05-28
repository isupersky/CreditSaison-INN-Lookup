package com.example.CreditSaisonINNLookup.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Bank {

  private String name;
  private String url;
  private String phone;
  private String city;

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

}
