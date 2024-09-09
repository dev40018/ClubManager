package ir.seriousGym.web.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import ir.seriousGym.web.dto.EventDto;
import static ir.seriousGym.web.mapper.EventMapper.mapToEvent;
import static ir.seriousGym.web.mapper.EventMapper.mapToEventDto;
import ir.seriousGym.web.model.Club;
import ir.seriousGym.web.model.Event;
import ir.seriousGym.web.repository.ClubRepo;
import ir.seriousGym.web.repository.EventRepo;
import ir.seriousGym.web.service.EventService;

@Service
public class EventServiceImpl implements EventService {

  private final EventRepo eventRepo;
  private final ClubRepo clubRepo;

  public EventServiceImpl(EventRepo eventRepo, ClubRepo clubRepo) {
    this.eventRepo = eventRepo;
    this.clubRepo = clubRepo;
  }

  @Override
  public void createEvent(long clubId, EventDto eventDto) {
    // first we are going to find the club to insert the events in it
    Club club = clubRepo.findById(clubId).get();
    // Repo methods only works with Event
    Event event = mapToEvent(eventDto);

    event.setClub(club);
    eventRepo.save(event);

  }

  @Override
  public List<EventDto> findAllEvents() {
    List<Event> events = eventRepo.findAll();
    return events.stream().map(event -> mapToEventDto(event)).collect(Collectors.toList());
  }

  @Override
  public EventDto findEventById(long eventId) {
    Event event = eventRepo.findById(eventId).get();
    return mapToEventDto(event);
  }

  @Override
  public void updateEvent(EventDto eventDto) {
    Event event = mapToEvent(eventDto);
    eventRepo.save(event);
  }

  @Override
  public void deleteEvent(long eventId) {
    eventRepo.deleteById(eventId);
  }

}
