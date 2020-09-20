package com.spring.event.driven.example.cases.domain.handlers;

import java.util.UUID;

import com.spring.event.driven.example.cases.domain.Context;
import com.spring.event.driven.example.cases.domain.aggregate.CaseAggregate;
import com.spring.event.driven.example.cases.domain.commands.SignCase;
import com.spring.event.driven.example.cases.domain.entities.CaseState;
import com.spring.event.driven.example.cases.domain.entities.SignerStatus;
import com.spring.event.driven.example.kernel.CommandHandler;

public class SignCaseHandler implements CommandHandler<CaseAggregate, SignCase, Context> {

  @Override
  public CaseAggregate handle(UUID stateID, CaseAggregate state, SignCase command, Context context) {    
    return new CaseAggregate(
      stateID, 
      state.getContractName(),
      state.getDocuments(),
      state.getSigners(),
      state.getCreatedDate(),
      state.getDueDate(),
      status(state, command.getStatus())
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
