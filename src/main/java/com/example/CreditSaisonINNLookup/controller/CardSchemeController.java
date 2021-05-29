package com.example.CreditSaisonINNLookup.controller;

import com.example.CreditSaisonINNLookup.dto.CardDetailDTO;
import com.example.CreditSaisonINNLookup.dto.CommonResponseDTO;
import com.example.CreditSaisonINNLookup.service.CardSchemeService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card-scheme/")
public class CardSchemeController {

  @Autowired
  CardSchemeService cardSchemeService;

  @GetMapping("verify/{bin}")
  public CommonResponseDTO<CardDetailDTO> verifyCardScheme(@PathVariable("bin") Long bin) {
    return cardSchemeService.verifyCardScheme(bin);
  }

  @GetMapping("stats")
  public CommonResponseDTO<List<Map<Long, Long>>> getStats(@RequestParam("start") Long start,
      @RequestParam("limit") Long limit) {
    return cardSchemeService.getStats(start, limit);
  }
}
