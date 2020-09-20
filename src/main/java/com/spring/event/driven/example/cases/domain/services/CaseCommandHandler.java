package com.spring.event.driven.example.cases.domain.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.event.driven.example.cases.domain.Context;
import com.spring.event.driven.example.cases.domain.aggregate.CaseAggregate;
import com.spring.event.driven.example.cases.domain.commands.CaseCommand;
import com.spring.event.driven.example.cases.domain.commands.CreateCase;
import com.spring.event.driven.example.cases.domain.commands.SignCase;
import com.spring.event.driven.example.cases.domain.handlers.CreateCaseHandler;
import com.spring.event.driven.example.cases.domain.handlers.SignCaseHandler;
import com.spring.event.driven.example.cases.application.repositories.CaseAggregateRepository;
import com.spring.event.driven.example.cases.application.repositories.CaseEventRepository;
import com.spring.event.driven.example.kernel.CommandHandlers;
import com.spring.event.driven.example.kernel.GlobalHandler;

import org.springframework.stereotype.Service;

@Service
class CaseCommandHandler extends GlobalHandler<CaseAggregate, CaseCommand, Context> {

  public CaseCommandHandler(
    CaseAggregateRepository stateRepository,
    CaseEventRepository eventRepository,
    ObjectMapper objectMapper
  ) {
    super(
      new CommandHandlers<CaseAggregate, CaseCommand, Context>()
        .register(CreateCase.class, new CreateCaseHandler())
        .register(SignCase.class, new SignCaseHandler()),
      eventRepository,
      stateRepository
    );
  }
  
}
