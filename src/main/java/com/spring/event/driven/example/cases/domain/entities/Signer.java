package com.spring.event.driven.example.cases.domain.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
@Table("signer")
public class Signer {
  @Column("signer_id") @Id String id;
  @Column("signer_name") String name;
  @Column("signer_status") SignerStatus status;
}
