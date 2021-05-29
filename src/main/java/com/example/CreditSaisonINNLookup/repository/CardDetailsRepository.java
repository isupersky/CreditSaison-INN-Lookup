package com.example.CreditSaisonINNLookup.repository;

import com.example.CreditSaisonINNLookup.entity.CardDetails;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CardDetailsRepository extends CrudRepository<CardDetails, Integer> {

  Optional<CardDetails> findByBin(long bin);

  @Query(value = "select bin,call_count FROM  card_details ORDER BY call_count DESC  LIMIT :start ,:limit", nativeQuery = true)
  Optional<List<Map<Long, Long>>> getStats(@Param("start")Long start, @Param("limit")Long limit);
}
