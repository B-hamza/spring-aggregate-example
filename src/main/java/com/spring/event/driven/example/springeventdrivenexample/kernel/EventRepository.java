package com.spring.event.driven.example.springeventdrivenexample.kernel;

public interface EventRepository<State, Command, Context> {
  
  public Event<State, Command, Context> save(Event<State, Command, Context> event);

}
