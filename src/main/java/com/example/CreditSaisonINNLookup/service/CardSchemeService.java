package com.example.CreditSaisonINNLookup.service;

import static com.example.CreditSaisonINNLookup.dto.CommonResponseDTO.failure;
import static com.example.CreditSaisonINNLookup.dto.CommonResponseDTO.success;

import com.example.CreditSaisonINNLookup.dto.CardDetailDTO;
import com.example.CreditSaisonINNLookup.dto.CommonResponseDTO;
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

  public CommonResponseDTO<CardDetailDTO> verifyCardScheme(Long bin) {
    ResponseEntity<CardDetails> responseEntity;
    HttpHeaders headers = new HttpHeaders();
    RestTemplate restTemplate = new RestTemplate();
    HttpEntity<String> entity = new HttpEntity<>(headers);
    Optional<CardDetails> cardDetails = cardDetailsRepository.findByBin(bin);
    if (cardDetails.isPresent()) {
      return success(mapCardDetailsToCardDetailDTO(cardDetails.get()));
    }
    try {
      responseEntity = restTemplate
          .exchange("https://lookup.binlist.net/" + bin, HttpMethod.GET, entity, CardDetails.class);
      responseEntity.getBody().setBin(bin);
      cardDetailsRepository.save(responseEntity.getBody());
    } catch (Exception e) {
      return failure("Invalid BIN/INN number");
    }
    return success(mapCardDetailsToCardDetailDTO(responseEntity.getBody()));
  }

  private CardDetailDTO mapCardDetailsToCardDetailDTO(CardDetails cardDetails){
    CardDetailDTO cardDetailDTO = new CardDetailDTO();
    cardDetailDTO.setScheme(cardDetails.getScheme()).setBank(cardDetails.getBank().getName())
        .setType(cardDetails.getType());
    return cardDetailDTO;
  }

}
