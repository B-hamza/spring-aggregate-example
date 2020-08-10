package com.spring.event.driven.example.springeventdrivenexample.kernel;

import java.util.UUID;

@FunctionalInterface
public interface CommandHandler<State, Command, Context> {

  public State handle(UUID stateID, State state, Command command, Context context);
  
}
