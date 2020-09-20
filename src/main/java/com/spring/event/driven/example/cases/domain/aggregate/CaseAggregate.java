package com.spring.event.driven.example.cases.domain.aggregate;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import com.spring.event.driven.example.cases.domain.entities.CaseState;
import com.spring.event.driven.example.cases.domain.entities.Document;
import com.spring.event.driven.example.cases.domain.entities.Signer;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor
@Table("case_aggregate")
public class CaseAggregate {
  @Column("case_id") @Id UUID caseId;
  @Column("contract_name") String contractName;
  @MappedCollection(idColumn = "case_id") Set<Document> documents;
  @MappedCollection(idColumn = "case_id") Set<Signer> signers;
  @Column("created_date") LocalDateTime createdDate;
  @Column("due_date") LocalDateTime dueDate;
  @Column("case_state") CaseState state;
}
