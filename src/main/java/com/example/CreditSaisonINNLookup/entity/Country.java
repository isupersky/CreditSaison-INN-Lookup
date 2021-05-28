package com.example.CreditSaisonINNLookup.entity;

public class Country {

  public String numeric;
  public String alpha2;
  public String name;
  public String emoji;
  public String currency;
  public int latitude;
  public int longitude;

  public String getNumeric() {
    return numeric;
  }

  public Country setNumeric(String numeric) {
    this.numeric = numeric;
    return this;
  }

  public String getAlpha2() {
    return alpha2;
  }

  public Country setAlpha2(String alpha2) {
    this.alpha2 = alpha2;
    return this;
  }

  public String getName() {
    return name;
  }

  public Country setName(String name) {
    this.name = name;
    return this;
  }

  public String getEmoji() {
    return emoji;
  }

  public Country setEmoji(String emoji) {
    this.emoji = emoji;
    return this;
  }

  public String getCurrency() {
    return currency;
  }

  public Country setCurrency(String currency) {
    this.currency = currency;
    return this;
  }

  public int getLatitude() {
    return latitude;
  }

  public Country setLatitude(int latitude) {
    this.latitude = latitude;
    return this;
  }

  public int getLongitude() {
    return longitude;
  }

  public Country setLongitude(int longitude) {
    this.longitude = longitude;
    return this;
  }

  @Override
  public String toString() {
    return "Country{" +
        "numeric='" + numeric + '\'' +
        ", alpha2='" + alpha2 + '\'' +
        ", name='" + name + '\'' +
        ", emoji='" + emoji + '\'' +
        ", currency='" + currency + '\'' +
        ", latitude=" + latitude +
        ", longitude=" + longitude +
        '}';
  }
}
