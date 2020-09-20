package com.spring.event.driven.example.cases.domain.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.Collections;

import com.spring.event.driven.example.DemoApplicationTests;
import com.spring.event.driven.example.cases.domain.Context;

import com.spring.event.driven.example.cases.domain.commands.CreateCase;
import com.spring.event.driven.example.cases.domain.entities.Document;
import com.spring.event.driven.example.cases.domain.entities.Signer;
import com.spring.event.driven.example.cases.domain.entities.SignerStatus;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CaseCommandHandlerTest extends DemoApplicationTests {

  @Autowired
  CaseService service;

  @Test
  public void handleCreateCommand() {
    Context context = new Context("hamza");
    Document doc = new Document("1", "test");
    Signer signer = new Signer("1", "hamza", SignerStatus.Pending);
    CreateCase command = new CreateCase("Faber", Collections.singleton(doc), Collections.singleton(signer), LocalDateTime.now());
    
    var aggregate = service.create(command, context);

    service.findById(aggregate.getCaseId()).ifPresent(content -> {
      assertEquals(aggregate, content);
    });
  }
  
}
