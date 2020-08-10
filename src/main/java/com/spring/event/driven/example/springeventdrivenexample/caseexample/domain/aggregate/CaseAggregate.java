package com.spring.event.driven.example.springeventdrivenexample.caseexample.domain.aggregate;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import com.spring.event.driven.example.springeventdrivenexample.caseexample.domain.entities.CaseProcess;
import com.spring.event.driven.example.springeventdrivenexample.caseexample.domain.entities.CaseState;
import com.spring.event.driven.example.springeventdrivenexample.caseexample.domain.entities.Document;
import com.spring.event.driven.example.springeventdrivenexample.caseexample.domain.entities.Signer;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
@Table("case_aggregate")
public class CaseAggregate {
  @Column("case_id") @Id UUID caseId;
  @Column("company_name") String companyName;
  @MappedCollection(idColumn = "document_id") Set<Document> documents;
  @MappedCollection(idColumn = "signer_id") Set<Signer> signers;
  @Column("due_date") LocalDateTime dueDate;
  @Column("case_state") CaseState state;
  @MappedCollection(idColumn = "process_id") Set<CaseProcess> caseProcesses;
}
