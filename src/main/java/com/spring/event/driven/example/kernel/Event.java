package com.spring.event.driven.example.kernel;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor
public class Event<State, Command, Context> {
  Long sequentialId;
  UUID eventId;
  UUID stateId;
  LocalDateTime date;
  State state;
  Command command;
  Context context;
}
