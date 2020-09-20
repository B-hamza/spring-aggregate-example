package com.spring.event.driven.example.cases.application.repositories;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.event.driven.example.cases.domain.Context;
import com.spring.event.driven.example.cases.domain.aggregate.CaseAggregate;
import com.spring.event.driven.example.cases.domain.commands.CaseCommand;
import com.spring.event.driven.example.kernel.Event;
import com.spring.event.driven.example.kernel.EventRepository;

import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.JdbcAggregateTemplate;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;

@Component
@AllArgsConstructor
public class CaseEventRepository 
  implements EventRepository<CaseAggregate, CaseCommand, Context> {

  private final JdbcAggregateTemplate jdbcAggregateTemplate;
  private final ObjectMapper objectMapper;

  @Override
  public Event<CaseAggregate, CaseCommand, Context> save(Event<CaseAggregate, CaseCommand, Context> event) {
    try {
      jdbcAggregateTemplate.save(new EventMapper(event));
      return event;
    } catch(IOException e) {
      return null;
    }
  }

  @Data
  @AllArgsConstructor
  @Table("events")
  class EventMapper {
    @Column("sequential_id") @Id Long sequentialId;
    @Column("event_id") UUID eventId;
    @Column("state_id") UUID stateId;
    @Column("date") LocalDateTime date;
    @Column("state") byte[] state;
    @Column("command") byte[] command;
    @Column("context") byte[] context;

    public EventMapper(Event<CaseAggregate, CaseCommand, Context> event) throws IOException {
      this(
        event.getSequentialId(),
        event.getEventId(),
        event.getStateId(),
        event.getDate(),
        objectMapper.writeValueAsBytes(event.getState()),
        objectMapper.writeValueAsBytes(event.getCommand()),
        objectMapper.writeValueAsBytes(event.getContext())
      );
    }

    Event<CaseAggregate, CaseCommand, Context> event() throws IOException {
      return Event.<CaseAggregate, CaseCommand, Context>builder()
        .sequentialId(sequentialId)
        .eventId(eventId)
        .stateId(stateId)
        .state(objectMapper.readValue(state, CaseAggregate.class))
        .date(date)
        .command(objectMapper.readValue(command, CaseCommand.class))
        .context(objectMapper.readValue(context, Context.class))
        .build();
    }
  }
  
}
