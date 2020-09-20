package com.spring.event.driven.example.cases.domain.handlers;

import java.time.LocalDateTime;
import java.util.UUID;

import com.spring.event.driven.example.cases.domain.Context;
import com.spring.event.driven.example.cases.domain.aggregate.CaseAggregate;
import com.spring.event.driven.example.cases.domain.commands.CreateCase;
import com.spring.event.driven.example.cases.domain.entities.CaseState;
import com.spring.event.driven.example.kernel.CreateCommandHandler;

public class CreateCaseHandler implements CreateCommandHandler<CaseAggregate, CreateCase, Context> {

  @Override
  public CaseAggregate handle(UUID stateID, CreateCase command, Context context) {
    return new CaseAggregate(
      stateID,
      command.getCompanyName(), 
      command.getDocuments(), 
      command.getSigners(), 
      LocalDateTime.now(),
      command.getDueDate(),
      CaseState.Created
    );
  }
  
}
