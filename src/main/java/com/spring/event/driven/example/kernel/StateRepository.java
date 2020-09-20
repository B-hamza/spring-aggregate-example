package com.spring.event.driven.example.kernel;

import java.util.Optional;
import java.util.UUID;

public interface StateRepository<State> {
  
  public State save(State state);

  public Optional<State> findById(UUID stateId);

}
