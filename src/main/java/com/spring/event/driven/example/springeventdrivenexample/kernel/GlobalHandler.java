package com.spring.event.driven.example.springeventdrivenexample.kernel;

import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

public class GlobalHandler<State, Command, Context> {

  private final CommandHandlers<State, Command, Context> handlers;
  private final EventRepository<State, Command, Context> eventRepository;
  private final StateRepository<State> stateRepository;

  public GlobalHandler(
    CommandHandlers<State, Command, Context> handlers,
    EventRepository<State, Command, Context> eventRepository,
    StateRepository<State> stateRepository
  ) {
    this.handlers = handlers;
    this.eventRepository = eventRepository;
    this.stateRepository = stateRepository;
  }

  public State create(Command command, Context context) {
    UUID stateId = UUID.randomUUID();
    return update(stateId, command, context);
  }

  @Transactional
  public State update(UUID stateId, Command command, Context context) {
    State newState = stateRepository.findById(stateId)
      .map(state -> handlers.apply(stateId, state, command, context))
      .orElseGet(() -> handlers.apply(stateId, null, command, context));
    UUID eventId = UUID.randomUUID();
    Event<State, Command, Context> event = new Event<>(null, eventId, stateId, newState, command, context);
    //eventRepository.save(event);
    return stateRepository.save(newState);
  }

}
