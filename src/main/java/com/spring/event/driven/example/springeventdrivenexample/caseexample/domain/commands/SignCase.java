package com.spring.event.driven.example.springeventdrivenexample.caseexample.domain.commands;

import java.time.LocalDateTime;

import com.spring.event.driven.example.springeventdrivenexample.caseexample.domain.entities.SignerStatus;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper=true)
@AllArgsConstructor
public class SignCase extends CaseCommand {
  String signerId;
  SignerStatus status;
  LocalDateTime date;
}
