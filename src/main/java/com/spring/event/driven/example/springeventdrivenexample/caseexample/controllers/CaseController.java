package com.spring.event.driven.example.springeventdrivenexample.caseexample.controllers;

import java.time.LocalDateTime;
import java.util.Collections;

import com.spring.event.driven.example.springeventdrivenexample.caseexample.domain.Context;
import com.spring.event.driven.example.springeventdrivenexample.caseexample.domain.aggregate.CaseAggregate;
import com.spring.event.driven.example.springeventdrivenexample.caseexample.domain.commands.CreateCase;
import com.spring.event.driven.example.springeventdrivenexample.caseexample.domain.entities.Document;
import com.spring.event.driven.example.springeventdrivenexample.caseexample.domain.entities.Signer;
import com.spring.event.driven.example.springeventdrivenexample.caseexample.domain.handlers.CaseCommandHandler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/cases")
public class CaseController {

  private final CaseCommandHandler handler;

  public CaseController(CaseCommandHandler handler) {
    this.handler = handler;
  }
  
  @RequestMapping(method = RequestMethod.POST)
  public CaseAggregate helloWorld() {
    Context context = new Context("hamza");
    Document doc = new Document("1", "test");
    Signer signer = new Signer("hamza", "test");
    CreateCase command = new CreateCase("Faber", Collections.singleton(doc), Collections.singleton(signer), LocalDateTime.now());
    return handler.create(command, context);
  }

}
