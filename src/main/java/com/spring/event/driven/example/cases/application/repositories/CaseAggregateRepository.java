package com.spring.event.driven.example.cases.application.repositories;

import java.util.Optional;
import java.util.UUID;

import com.spring.event.driven.example.cases.domain.aggregate.CaseAggregate;
import com.spring.event.driven.example.kernel.StateRepository;

import org.springframework.data.jdbc.core.JdbcAggregateTemplate;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CaseAggregateRepository implements StateRepository<CaseAggregate> {

  private final JdbcAggregateTemplate jdbcAggregateTemplate;

  @Override
  public CaseAggregate save(CaseAggregate state) {
    return jdbcAggregateTemplate.insert(state);
  }

  @Override
  public Optional<CaseAggregate> findById(UUID stateId) {
    return Optional.ofNullable(jdbcAggregateTemplate.findById(stateId, CaseAggregate.class));
  }


  
}
