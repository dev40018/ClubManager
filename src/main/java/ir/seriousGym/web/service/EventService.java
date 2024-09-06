package ir.seriousGym.web.service;

import ir.seriousGym.web.dto.EventDto;

public interface EventService {
  void createEvent(long clubId, EventDto eventDto);
}

