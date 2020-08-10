package com.spring.event.driven.example.springeventdrivenexample.caseexample.repositories;

import java.util.UUID;

import com.spring.event.driven.example.springeventdrivenexample.caseexample.domain.aggregate.CaseAggregate;
import com.spring.event.driven.example.springeventdrivenexample.kernel.StateRepository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaseAggregateRepository
  extends StateRepository<CaseAggregate>,
  PagingAndSortingRepository<CaseAggregate, UUID> {
  
}
