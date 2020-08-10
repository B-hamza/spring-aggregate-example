package com.spring.event.driven.example.springeventdrivenexample.caseexample.repositories;

import java.util.UUID;

import com.spring.event.driven.example.springeventdrivenexample.caseexample.domain.Context;
import com.spring.event.driven.example.springeventdrivenexample.caseexample.domain.aggregate.CaseAggregate;
import com.spring.event.driven.example.springeventdrivenexample.caseexample.domain.commands.CaseCommand;
import com.spring.event.driven.example.springeventdrivenexample.kernel.Event;
import com.spring.event.driven.example.springeventdrivenexample.kernel.EventRepository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaseEventRepository 
  extends EventRepository<CaseAggregate, CaseCommand, Context>, 
  PagingAndSortingRepository<Event<CaseAggregate, CaseCommand, Context>, UUID> {
  
}
