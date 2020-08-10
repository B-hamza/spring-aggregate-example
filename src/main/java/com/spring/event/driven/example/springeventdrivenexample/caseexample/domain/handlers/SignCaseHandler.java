package com.spring.event.driven.example.springeventdrivenexample.caseexample.domain.handlers;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.UUID;

import com.spring.event.driven.example.springeventdrivenexample.caseexample.domain.Context;
import com.spring.event.driven.example.springeventdrivenexample.caseexample.domain.aggregate.CaseAggregate;
import com.spring.event.driven.example.springeventdrivenexample.caseexample.domain.commands.SignCase;
import com.spring.event.driven.example.springeventdrivenexample.caseexample.domain.entities.CaseProcess;
import com.spring.event.driven.example.springeventdrivenexample.caseexample.domain.entities.CaseState;
import com.spring.event.driven.example.springeventdrivenexample.caseexample.domain.entities.SignerStatus;
import com.spring.event.driven.example.springeventdrivenexample.kernel.CommandHandler;

public class SignCaseHandler implements CommandHandler<CaseAggregate, SignCase, Context> {

  @Override
  public CaseAggregate handle(UUID stateID, CaseAggregate state, SignCase command, Context context) {
    CaseProcess process = new CaseProcess(UUID.randomUUID(), command.getSignerId(), LocalDateTime.now(), command.getStatus());
    
    return new CaseAggregate(
      stateID, 
      state.getCompanyName(), 
      state.getDocuments(),
      state.getSigners(), 
      state.getDueDate(), 
      status(state, command.getStatus()), 
      Collections.singleton(process)
    );
  }

  public CaseState status(CaseAggregate state, SignerStatus status) {
    // Whatever, this is just an example
    switch(status) {
      case Signed: return CaseState.Pending;
      case Refused: return CaseState.Refused;
      default: return CaseState.Created;
    }
  }  
  
}
