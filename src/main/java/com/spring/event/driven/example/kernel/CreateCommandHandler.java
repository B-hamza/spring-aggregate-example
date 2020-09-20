package com.spring.event.driven.example.kernel;

import java.util.UUID;

public interface CreateCommandHandler<State, Command, Context> extends CommandHandler<State, Command, Context> {

  public State handle(UUID stateID, Command command, Context context);


  default State handle(UUID stateID, State state, Command command, Context context) {
    return handle(stateID, command, context);
  }
}
