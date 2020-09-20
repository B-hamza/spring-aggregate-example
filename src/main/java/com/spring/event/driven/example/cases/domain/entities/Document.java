package com.spring.event.driven.example.cases.domain.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
@Table("document")
public class Document {
  @Column("document_id") @Id String documentId;
  @Column("document_name") String documentName;
}
