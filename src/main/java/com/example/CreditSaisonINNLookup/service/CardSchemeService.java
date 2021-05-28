package com.example.CreditSaisonINNLookup.service;

import static com.example.CreditSaisonINNLookup.dto.ResponseDTO.failure;
import static com.example.CreditSaisonINNLookup.dto.ResponseDTO.success;

import com.example.CreditSaisonINNLookup.dto.ResponseDTO;
import com.example.CreditSaisonINNLookup.entity.CardDetails;
import com.example.CreditSaisonINNLookup.repository.CardDetailsRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CardSchemeService {

  @Autowired
  CardDetailsRepository cardDetailsRepository;

  public ResponseDTO<CardDetails> verifyCardScheme(Long bin) {
    ResponseEntity<CardDetails> responseEntity;
    HttpHeaders headers = new HttpHeaders();
    RestTemplate restTemplate = new RestTemplate();
    HttpEntity<String> entity = new HttpEntity<>(headers);
    Optional<CardDetails> cardDetails = cardDetailsRepository.findByBin(bin);
    if (cardDetails.isPresent()) {
      return success(cardDetails.get());
    }
    try {
      responseEntity = restTemplate
          .exchange("https://lookup.binlist.net/" + bin, HttpMethod.GET, entity, CardDetails.class);
      responseEntity.getBody().setBin(bin);
      cardDetailsRepository.save(responseEntity.getBody());
    } catch (Exception e) {
      return failure(e.getMessage());
    }
    return success(responseEntity.getBody());
  }

}
