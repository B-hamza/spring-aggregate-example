package com.spring.event.driven.example.kernel;

import java.time.LocalDateTime;
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

  @Transactional
  public State create(Command command, Context context) {
    UUID stateId = UUID.randomUUID();
    State state = handlers.apply(stateId, null, command, context);
    return save(stateId, state, command, context);
  }

  @Transactional
  public State update(UUID stateId, Command command, Context context) {
    State newState = stateRepository.findById(stateId)
      .map(state -> handlers.apply(stateId, state, command, context))
      .orElseThrow();
    return save(stateId, newState, command, context);
  }

  @Transactional
  private State save(UUID stateId, State newState, Command command, Context context) {
    UUID eventId = UUID.randomUUID();
    Event<State, Command, Context> event = Event.<State, Command, Context>builder()
      .eventId(eventId)
      .stateId(stateId)
      .state(newState)
      .date(LocalDateTime.now())
      .command(command)
      .context(context)
      .build();
    eventRepository.save(event);
    return stateRepository.save(newState);
  }

}
