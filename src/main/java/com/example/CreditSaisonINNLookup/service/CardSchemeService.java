package com.example.CreditSaisonINNLookup.service;

import static com.example.CreditSaisonINNLookup.dto.ResponseDTO.failure;
import static com.example.CreditSaisonINNLookup.dto.ResponseDTO.success;

import com.example.CreditSaisonINNLookup.dto.ResponseDTO;
import com.example.CreditSaisonINNLookup.entity.CardDetail;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CardSchemeService {

  public ResponseDTO<CardDetail> verifyCardScheme(Long bin) {
    ResponseEntity<CardDetail> responseEntity;
    HttpHeaders headers = new HttpHeaders();
    RestTemplate restTemplate = new RestTemplate();
    HttpEntity<String> entity = new HttpEntity<>(headers);
    try {
      responseEntity = restTemplate
          .exchange("https://lookup.binlist.net/" + bin, HttpMethod.GET, entity, CardDetail.class);
    } catch (Exception e) {
      return failure(e.getMessage());
    }
    return success(responseEntity.getBody());
  }

}
