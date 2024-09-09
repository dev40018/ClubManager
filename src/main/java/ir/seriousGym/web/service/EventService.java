package ir.seriousGym.web.service;

import java.util.List;

import ir.seriousGym.web.dto.EventDto;

public interface EventService {
  void createEvent(long clubId, EventDto eventDto);

  List<EventDto> findAllEvents();

  EventDto findEventById(long eventId);

  void updateEvent(EventDto eventDto);
}
