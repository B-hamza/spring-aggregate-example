package com.spring.event.driven.example.cases.domain.commands;

import java.time.LocalDateTime;
import java.util.Set;

import com.spring.event.driven.example.cases.domain.entities.Document;
import com.spring.event.driven.example.cases.domain.entities.Signer;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper=true)
@AllArgsConstructor
public class CreateCase extends CaseCommand {
  String companyName;
  Set<Document> documents;
  Set<Signer> signers;
  LocalDateTime dueDate;
}
