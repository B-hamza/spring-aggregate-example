package com.spring.event.driven.example.springeventdrivenexample.caseexample.controllers;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.spring.event.driven.example.springeventdrivenexample.caseexample.domain.Context;
import com.spring.event.driven.example.springeventdrivenexample.caseexample.domain.aggregate.CaseAggregate;
import com.spring.event.driven.example.springeventdrivenexample.caseexample.domain.commands.CreateCase;
import com.spring.event.driven.example.springeventdrivenexample.caseexample.domain.entities.Document;
import com.spring.event.driven.example.springeventdrivenexample.caseexample.domain.entities.Signer;
import com.spring.event.driven.example.springeventdrivenexample.caseexample.domain.handlers.CaseCommandHandler;
import com.spring.event.driven.example.springeventdrivenexample.caseexample.repositories.CaseAggregateRepository;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cases")
public class CaseController {

  private final CaseCommandHandler handler;
  private final CaseAggregateRepository repository;

  public CaseController(
    CaseCommandHandler handler,
    CaseAggregateRepository repository) {
    this.handler = handler;
    this.repository = repository;
  }
  
  @RequestMapping(method = RequestMethod.POST, produces = {"application/json"})
  public CaseAggregate create() {
    Context context = new Context("hamza");
    Document doc = new Document("1", "test");
    Signer signer = new Signer("hamza", "test");
    CreateCase command = new CreateCase("Faber", Collections.singleton(doc), Collections.singleton(signer), LocalDateTime.now());
    return handler.create(command, context);
  }

  @RequestMapping(method = RequestMethod.GET, produces = {"application/json"})
  public Iterable<CaseAggregate> allCases() {
    return repository.findAll();
  }

}
