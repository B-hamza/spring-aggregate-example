package com.spring.event.driven.example.springeventdrivenexample.caseexample.domain.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
@Table("case_process")
public class CaseProcess {
  @Column("process_id") @Id UUID processId;
  @Column("signer_id") String signerId;
  @Column("date") LocalDateTime date;
  @Column("signer_state") SignerStatus status;
}
