package com.example.CreditSaisonINNLookup.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CardDetails {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;
  private Long bin;
  @Embedded
  private Number number;
  private String scheme;
  private String type;
  private String brand;
  private boolean prepaid;
  @Embedded
  private Country country;
  @Embedded
  private Bank bank;

  public int getId() {
    return id;
  }

  public CardDetails setId(int id) {
    this.id = id;
    return this;
  }

  public Long getBin() {
    return bin;
  }

  public CardDetails setBin(Long bin) {
    this.bin = bin;
    return this;
  }

  public Number getNumber() {
    return number;
  }

  public CardDetails setNumber(Number number) {
    this.number = number;
    return this;
  }

  public String getScheme() {
    return scheme;
  }

  public CardDetails setScheme(String scheme) {
    this.scheme = scheme;
    return this;
  }

  public String getType() {
    return type;
  }

  public CardDetails setType(String type) {
    this.type = type;
    return this;
  }

  public String getBrand() {
    return brand;
  }

  public CardDetails setBrand(String brand) {
    this.brand = brand;
    return this;
  }

  public boolean isPrepaid() {
    return prepaid;
  }

  public CardDetails setPrepaid(boolean prepaid) {
    this.prepaid = prepaid;
    return this;
  }

  public Country getCountry() {
    return country;
  }

  public CardDetails setCountry(Country country) {
    this.country = country;
    return this;
  }

  public Bank getBank() {
    return bank;
  }

  public CardDetails setBank(Bank bank) {
    this.bank = bank;
    return this;
  }
}

