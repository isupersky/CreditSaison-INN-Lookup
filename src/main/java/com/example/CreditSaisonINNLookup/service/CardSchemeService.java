package com.example.CreditSaisonINNLookup.service;

import static com.example.CreditSaisonINNLookup.dto.CommonResponseDTO.failure;
import static com.example.CreditSaisonINNLookup.dto.CommonResponseDTO.success;

import com.example.CreditSaisonINNLookup.dto.CardDetailDTO;
import com.example.CreditSaisonINNLookup.dto.CommonResponseDTO;
import com.example.CreditSaisonINNLookup.entity.CardDetails;
import com.example.CreditSaisonINNLookup.repository.CardDetailsRepository;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.modelmapper.ModelMapper;
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

  @Autowired
  private ModelMapper modelMapper;

  public CommonResponseDTO<CardDetailDTO> verifyCardScheme(Long bin) {
    ResponseEntity<CardDetails> responseEntity;
    HttpHeaders headers = new HttpHeaders();
    RestTemplate restTemplate = new RestTemplate();
    HttpEntity<String> entity = new HttpEntity<>(headers);
    Optional<CardDetails> cardDetails = cardDetailsRepository.findByBin(bin);
    if (cardDetails.isPresent()) {
      cardDetails.get().setCallCount(cardDetails.get().getCallCount() + 1);
      cardDetailsRepository.save(cardDetails.get());
      return success(mapCardDetailsToCardDetailDTO(cardDetails.get()));
    }
    try {
      responseEntity = restTemplate
          .exchange("https://lookup.binlist.net/" + bin, HttpMethod.GET, entity, CardDetails.class);
      responseEntity.getBody().setBin(bin);
      responseEntity.getBody().setCallCount(1L);
      cardDetailsRepository.save(responseEntity.getBody());
    } catch (Exception e) {
      return failure("Invalid BIN/INN number");
    }
    return success(mapCardDetailsToCardDetailDTO(responseEntity.getBody()));
  }

  private CardDetailDTO mapCardDetailsToCardDetailDTO(CardDetails cardDetails) {
    CardDetailDTO cardDetailDTO = modelMapper.map(cardDetails, CardDetailDTO.class);
    return cardDetailDTO;
  }

  public CommonResponseDTO<List<Map<Long, Long>>> getStats(Long start, Long limit) {
    if (start < 1 || limit < 1) {
      return failure("invalid Inputs: values of start and limit must be greater than 0");
    }
    Optional<List<Map<Long, Long>>> stats = cardDetailsRepository.getStats(start - 1, limit);
    if (stats.isPresent() && stats.get().size() != 0) {
      return success(stats.get(), start, limit);
    } else {
      return failure("No Stats Found");
    }
  }
}
