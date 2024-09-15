package ir.seriousGym.web.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ir.seriousGym.web.dto.ClubDto;
import ir.seriousGym.web.dto.EventDto;
import ir.seriousGym.web.model.Event;
import ir.seriousGym.web.model.UserEntity;
import ir.seriousGym.web.security.SecurityUtil;
import ir.seriousGym.web.service.EventService;
import ir.seriousGym.web.service.UserService;
import jakarta.validation.Valid;

@Controller
public class EventController {

  private final EventService eventService;
  private final UserService userService;

  public EventController(EventService eventService, UserService userService) {
    this.eventService = eventService;
    this.userService = userService;
  }

  @GetMapping("/events")
  public String showAllEvents(Model model) {
    UserEntity user = new UserEntity();
    List<EventDto> events = eventService.findAllEvents();
    String username = SecurityUtil.getUserBySession();
    if(username != null){
      user = userService.findByUsername(username);
      model.addAttribute("user", user);
    }
    model.addAttribute("user", user);
    model.addAttribute("events", events);
    return "events-list";
  }

  @GetMapping("/events/{eventId}")
  public String showEventsDetail(
      @PathVariable("eventId") long eventId,
      Model model) {
    UserEntity user = new UserEntity();
    EventDto eventDto = eventService.findEventById(eventId);
    String username = SecurityUtil.getUserBySession();
    if(username != null){
      user = userService.findByUsername(username);
      model.addAttribute("user", user);
    }
    model.addAttribute("club", eventDto);
    model.addAttribute("user", user);
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
      @ModelAttribute("event") EventDto eventDto, BindingResult result,
      Model model) {
    if (result.hasErrors()) {
      model.addAttribute("event", eventDto);
      return "create-clubs";
    }
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

  @PostMapping("/events/{eventId}/edit")
  // @Valid would trigger constraints that exists in ClubDto
  public String updateEvent(@PathVariable("eventId") long eventId,
      @Valid @ModelAttribute("event") EventDto eventDto,
      BindingResult result,
      Model model) {
    if (result.hasErrors()) {
      model.addAttribute("event", eventDto);
      return "event-edit";
    }
    EventDto eventDto1 = eventService.findEventById(eventId); // this is the lazy loading way
    eventDto.setId(eventId);
    eventDto.setClub(eventDto1.getClub()); // this is the lazy loading way
    eventService.updateEvent(eventDto);
    return "redirect:/events";
  }

  // Delete
  @GetMapping("events/{eventId}/delete")
  public String deleteEvent(@PathVariable("eventId") long eventId) {
    eventService.deleteEvent(eventId);
    return "redirect:/events";
  }

}
