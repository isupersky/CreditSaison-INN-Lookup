package com.example.CreditSaisonINNLookup.entity;

public class Number {

  public int length;
  public boolean luhn;

  public int getLength() {
    return length;
  }

  public Number setLength(int length) {
    this.length = length;
    return this;
  }

  public boolean isLuhn() {
    return luhn;
  }

  public Number setLuhn(boolean luhn) {
    this.luhn = luhn;
    return this;
  }
}
