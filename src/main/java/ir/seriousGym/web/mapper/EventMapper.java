package ir.seriousGym.web.mapper;

import ir.seriousGym.web.dto.EventDto;
import ir.seriousGym.web.model.Event;

public class EventMapper {
    public static  Event mapToEvent(EventDto eventDto){
      Event event = Event.builder()
      .id(eventDto.getId())
      .name(eventDto.getName())
      .startTime(eventDto.getStartTime())
      .endTime(eventDto.getEndTime())
      .photoUrl(eventDto.getPhotoUrl())
      .createdOn(eventDto.getCreatedOn())
      .type(eventDto.getType())
      .updatedOn(eventDto.getUpdatedOn())
      .build();
      return event;
  }
}
