package com.example.CreditSaisonINNLookup.controller;

import com.example.CreditSaisonINNLookup.dto.ResponseDTO;
import com.example.CreditSaisonINNLookup.entity.CardDetail;
import com.example.CreditSaisonINNLookup.service.CardSchemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card-scheme/")
public class CardSchemeController {

  @Autowired
  CardSchemeService cardSchemeService;

  @GetMapping("verify/{bin}")
  public ResponseDTO<CardDetail> verifyCardScheme(@PathVariable("bin") Long bin) {
    return cardSchemeService.verifyCardScheme(bin);
  }
}
