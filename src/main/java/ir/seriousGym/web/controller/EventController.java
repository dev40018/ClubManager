package ir.seriousGym.web.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ir.seriousGym.web.dto.ClubDto;
import ir.seriousGym.web.dto.EventDto;
import ir.seriousGym.web.model.Event;
import ir.seriousGym.web.service.EventService;

@Controller
public class EventController {

  private final EventService eventService;

  public EventController(EventService eventService) {
    this.eventService = eventService;
  }

  @GetMapping("/events")
  public String showAllEvents(Model model) {
    List<EventDto> events = eventService.findAllEvents();
    model.addAttribute("events", events);
    return "events-list";
  }

  @GetMapping("/events/{eventId}")
  public String showEventsDetail(
      @PathVariable("eventId") long eventId,
      Model model) {
    EventDto eventDto = eventService.findEventById(eventId);
    model.addAttribute("event", eventDto);
    return "event-detail";
  }

  @GetMapping("/events/{clubId}/new")
  public String createEventForm(
      @PathVariable("clubId") long clubId,
      Model model) {
    Event event = new Event();
    model.addAttribute("clubId", clubId);
    model.addAttribute("event", event);
    return "events-create";

  }

  @PostMapping("/events/{clubId}")
  public String createEvent(
      @PathVariable("clubId") long clubId,
      @ModelAttribute("event") EventDto eventDto,
      Model model) {
    eventService.createEvent(clubId, eventDto);
    return "redirect:/clubs/" + clubId;
  }

  // Update
  @GetMapping("/events/{eventId}/edit")
  public String editEventForm(@PathVariable("eventId") long eventId, Model model) {
    EventDto eventDto = eventService.findEventById(eventId);
    model.addAttribute("event", eventDto);
    return "event-edit";
  }

}
