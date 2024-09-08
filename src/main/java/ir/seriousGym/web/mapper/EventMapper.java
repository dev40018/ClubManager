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
      .club(eventDto.getClub())
      .build();
      return event;
  }

  public static EventDto mapToEventDto(Event event){
    EventDto eventDto = EventDto.builder()
    .id(event.getId())
    .name(event.getName())
    .startTime(event.getStartTime())
    .endTime(event.getEndTime())
    .photoUrl(event.getPhotoUrl())
    .createdOn(event.getCreatedOn())
    .type(event.getType())
    .updatedOn(event.getUpdatedOn())
    .club(event.getClub())
    .build();
    return eventDto;
}
}
