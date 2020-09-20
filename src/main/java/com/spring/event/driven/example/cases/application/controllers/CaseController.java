package com.spring.event.driven.example.cases.application.controllers;

import com.spring.event.driven.example.cases.domain.aggregate.CaseAggregate;
import com.spring.event.driven.example.cases.domain.services.CaseService;
import com.spring.event.driven.example.cases.application.repositories.CaseAggregateRepository;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cases")
public class CaseController {

  private final CaseService service;
  private final CaseAggregateRepository repository;

  public CaseController(
    CaseService service,
    CaseAggregateRepository repository) {
    this.service = service;
    this.repository = repository;
  }
  
  @RequestMapping(method = RequestMethod.POST, produces = {"application/json"})
  public CaseAggregate create() {
    return null;
  }

  @RequestMapping(method = RequestMethod.GET, produces = {"application/json"})
  public Iterable<CaseAggregate> allCases() {
    return null;
  }

  @RequestMapping(path = "{caseId}/sign", method = RequestMethod.POST, produces = {"application/json"})
  public CaseAggregate sign(@PathVariable String caseId) {
    return null;
  }

}
