package com.example.CreditSaisonINNLookup.entity;

public class CardDetail {
  public Number number;
  public String scheme;
  public String type;
  public String brand;
  public boolean prepaid;
  public Country country;
  public Bank bank;

  public Number getNumber() {
    return number;
  }

  public CardDetail setNumber(Number number) {
    this.number = number;
    return this;
  }

  public String getScheme() {
    return scheme;
  }

  public CardDetail setScheme(String scheme) {
    this.scheme = scheme;
    return this;
  }

  public String getType() {
    return type;
  }

  public CardDetail setType(String type) {
    this.type = type;
    return this;
  }

  public String getBrand() {
    return brand;
  }

  public CardDetail setBrand(String brand) {
    this.brand = brand;
    return this;
  }

  public boolean isPrepaid() {
    return prepaid;
  }

  public CardDetail setPrepaid(boolean prepaid) {
    this.prepaid = prepaid;
    return this;
  }

  public Country getCountry() {
    return country;
  }

  public CardDetail setCountry(Country country) {
    this.country = country;
    return this;
  }

  public Bank getBank() {
    return bank;
  }

  public CardDetail setBank(Bank bank) {
    this.bank = bank;
    return this;
  }
}

