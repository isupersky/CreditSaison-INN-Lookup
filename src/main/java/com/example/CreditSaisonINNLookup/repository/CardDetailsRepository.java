package com.example.CreditSaisonINNLookup.repository;

import com.example.CreditSaisonINNLookup.entity.CardDetails;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface CardDetailsRepository extends CrudRepository<CardDetails, Integer> {

  Optional<CardDetails> findByBin(long bin);
}
