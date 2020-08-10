package com.spring.event.driven.example.springeventdrivenexample.caseexample.domain.handlers;

import java.util.Collections;
import java.util.UUID;

import com.spring.event.driven.example.springeventdrivenexample.caseexample.domain.Context;
import com.spring.event.driven.example.springeventdrivenexample.caseexample.domain.aggregate.CaseAggregate;
import com.spring.event.driven.example.springeventdrivenexample.caseexample.domain.commands.CreateCase;
import com.spring.event.driven.example.springeventdrivenexample.caseexample.domain.entities.CaseState;
import com.spring.event.driven.example.springeventdrivenexample.kernel.CommandHandler;

public class CreateCaseHandler implements CommandHandler<CaseAggregate, CreateCase, Context> {

  @Override
  public CaseAggregate handle(UUID stateID, CaseAggregate state, CreateCase command, Context context) {
    return new CaseAggregate(
      null,
      command.getCompanyName(), 
      command.getDocuments(), 
      command.getSigners(), 
      command.getDueDate(), 
      CaseState.Created, 
      Collections.emptySet()
    );
  }
  
}
