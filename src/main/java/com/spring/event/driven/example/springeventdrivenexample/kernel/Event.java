package com.spring.event.driven.example.springeventdrivenexample.kernel;

import java.util.UUID;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class Event<State, Command, Context> {
  Long sequentialId;
  @Id UUID eventId;
  UUID stateId;
  State state;
  Command command;
  Context context;
}
