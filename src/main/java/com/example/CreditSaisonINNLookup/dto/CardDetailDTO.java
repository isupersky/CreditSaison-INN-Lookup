package com.example.CreditSaisonINNLookup.dto;

public class CardDetailDTO {

  private String scheme;
  private String type;
  private String bank;

  public String getScheme() {
    return scheme;
  }

  public CardDetailDTO setScheme(String scheme) {
    this.scheme = scheme;
    return this;
  }

  public String getType() {
    return type;
  }

  public CardDetailDTO setType(String type) {
    this.type = type;
    return this;
  }

  public String getBank() {
    return bank;
  }

  public CardDetailDTO setBank(String bank) {
    this.bank = bank;
    return this;
  }
}

