package com.spring.event.driven.example.kernel;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CommandHandlers<State, Command, Context> {

  private final Map<Class<?>, CommandHandler<State, Command, Context>> handlers;

  public CommandHandlers() {
    this.handlers = new HashMap<>();
  }

  @SuppressWarnings("unchecked")
  public <C extends Command> CommandHandlers<State, Command, Context> register(Class<C> clazz, CommandHandler<State, C, Context> handler) {
    handlers.put(clazz, (CommandHandler<State, Command, Context>)handler);
    return this;
  }

  public State apply(UUID stateId, State state, Command command, Context context) {
    return handlers.get(command.getClass())
      .handle(stateId, state, command, context);
  }
  
}
