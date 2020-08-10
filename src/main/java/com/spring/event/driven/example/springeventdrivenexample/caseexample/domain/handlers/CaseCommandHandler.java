package com.spring.event.driven.example.springeventdrivenexample.caseexample.domain.handlers;

import com.spring.event.driven.example.springeventdrivenexample.caseexample.domain.Context;
import com.spring.event.driven.example.springeventdrivenexample.caseexample.domain.aggregate.CaseAggregate;
import com.spring.event.driven.example.springeventdrivenexample.caseexample.domain.commands.CaseCommand;
import com.spring.event.driven.example.springeventdrivenexample.caseexample.domain.commands.CreateCase;
import com.spring.event.driven.example.springeventdrivenexample.caseexample.domain.commands.SignCase;
import com.spring.event.driven.example.springeventdrivenexample.caseexample.repositories.CaseAggregateRepository;
import com.spring.event.driven.example.springeventdrivenexample.caseexample.repositories.CaseEventRepository;
import com.spring.event.driven.example.springeventdrivenexample.kernel.CommandHandlers;
import com.spring.event.driven.example.springeventdrivenexample.kernel.GlobalHandler;

import org.springframework.stereotype.Service;

@Service
public class CaseCommandHandler extends GlobalHandler<CaseAggregate, CaseCommand, Context> {

  public CaseCommandHandler(
    CaseAggregateRepository stateRepository,
    CaseEventRepository eventRepository
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
