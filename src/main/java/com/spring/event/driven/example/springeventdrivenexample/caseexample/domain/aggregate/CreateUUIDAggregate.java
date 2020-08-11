package com.spring.event.driven.example.springeventdrivenexample.caseexample.domain.aggregate;

import java.util.UUID;

import org.springframework.data.relational.core.conversion.MutableAggregateChange;
import org.springframework.data.relational.core.mapping.event.BeforeConvertCallback;
import org.springframework.data.relational.core.mapping.event.BeforeSaveCallback;
import org.springframework.stereotype.Component;

@Component
class CreateUUIDAggregate implements BeforeConvertCallback<CaseAggregate>, BeforeSaveCallback<CaseAggregate> {

  @Override
  public CaseAggregate onBeforeConvert(CaseAggregate aggregate) {
    return new CaseAggregate(UUID.randomUUID(), aggregate.getCompanyName(), aggregate.getDocuments(),
        aggregate.getSigners(), aggregate.getDueDate(), aggregate.getState(), aggregate.getCaseProcesses());
  }

  @Override
  public CaseAggregate onBeforeSave(CaseAggregate aggregate, MutableAggregateChange<CaseAggregate> aggregateChange) {
    return new CaseAggregate(UUID.randomUUID(), aggregate.getCompanyName(), aggregate.getDocuments(),
        aggregate.getSigners(), aggregate.getDueDate(), aggregate.getState(), aggregate.getCaseProcesses());
  }
}
