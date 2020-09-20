package com.spring.event.driven.example.cases.domain.services;

import java.util.Optional;
import java.util.UUID;

import com.spring.event.driven.example.cases.application.repositories.CaseAggregateRepository;
import com.spring.event.driven.example.cases.domain.Context;
import com.spring.event.driven.example.cases.domain.aggregate.CaseAggregate;
import com.spring.event.driven.example.cases.domain.commands.CaseCommand;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CaseService {

  private final CaseCommandHandler commandHandler;
  private final CaseAggregateRepository repository;

  public CaseAggregate create(CaseCommand command, Context context) {
    return commandHandler.create(command, context);
  }

  public Optional<CaseAggregate> findById(UUID id) {
    return repository.findById(id);
  }
  
}
