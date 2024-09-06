package ir.seriousGym.web.service.impl;

import org.springframework.stereotype.Service;

import ir.seriousGym.web.dto.EventDto;
import ir.seriousGym.web.model.Club;
import ir.seriousGym.web.model.Event;
import ir.seriousGym.web.repository.ClubRepo;
import ir.seriousGym.web.repository.EventRepo;
import ir.seriousGym.web.service.EventService;

@Service
public class EventServiceImpl implements EventService{

  private final EventRepo eventRepo;
  private final ClubRepo clubRepo;
  public EventServiceImpl(EventRepo eventRepo, ClubRepo clubRepo) {
    this.eventRepo = eventRepo;
    this.clubRepo = clubRepo;
  }

  @Override
  public void createEvent(long clubId, EventDto eventDto) {
    //first we are going to find the club to insert the events in it
    Club club = clubRepo.findById(clubId).get();
    // Repo methods only works with Event 
    Event event = mapToEvent(eventDto);

    event.setClub(club);
    eventRepo.save(event);



  }
  private Event mapToEvent(EventDto eventDto){
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
