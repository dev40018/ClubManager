package ir.seriousGym.web.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ir.seriousGym.web.dto.ClubDto;
import ir.seriousGym.web.model.Club;
import ir.seriousGym.web.service.ClubService;
import jakarta.validation.Valid;

//@RestController its Only For RestAPI, doesn't works with views
@Controller
public class ClubController {

  private final ClubService clubService;

  public ClubController(ClubService clubService) {
    this.clubService = clubService;
  }

  @GetMapping("/clubs")
  // Model will allow us to put stuff on webpage
  public String listAllClubs(Model model) {
    List<ClubDto> clubs = clubService.findAllClubs();
    model.addAttribute("clubs", clubs);
    return "clubs-list";
  }

  @GetMapping("/clubs/new")
  public String createClubForm(Model model) {
    Club club = new Club();
    model.addAttribute("club", club);
    return "create-clubs";
  }

  @PostMapping("/clubs/new")
  public String saveClub(@Valid @ModelAttribute("club") ClubDto clubDto,
      BindingResult result,
      Model model) {
    if (result.hasErrors()) {
      model.addAttribute("club", clubDto);
      return "create-clubs";
    }
    clubService.saveClub(clubDto);
    return "redirect:/clubs";
  }

  @GetMapping("/clubs/{clubId}/edit")
  public String editClubForm(@PathVariable("clubId") long clubId, Model model) {
    ClubDto club = clubService.findClubById(clubId);
    model.addAttribute("club", club);
    return "clubs-edit";
  }

  @PostMapping("/clubs/{clubId}/edit")
  // @Valid would trigger constraints that exists in ClubDto
  public String updateClub(@PathVariable("clubId") long clubId,
      @Valid @ModelAttribute("club") ClubDto clubDto, Model model,
      BindingResult result) {
    if (result.hasErrors()) {
      model.addAttribute("club", clubDto);
      return "clubs-edit";
    }
    clubDto.setId(clubId);
    clubService.updateClub(clubDto);
    return "redirect:/clubs";
  }

  @GetMapping("/clubs/{clubId}")
  public String showClubDetail(@PathVariable("clubId") long clubId,
      Model model) {
    ClubDto clubDto = clubService.findClubById(clubId);
    model.addAttribute("club", clubDto);
    return "clubs-detail";
  }

  @GetMapping("/clubs/{clubId}/delete")
  public String deleteClub(@PathVariable("clubId") long clubId) {
    clubService.deleteClub(clubId);
    return "redirect:/clubs";
  }

  @GetMapping("/clubs/search")
  public String searchClub(
      @RequestParam(value = "query") String query,
      Model model) {
    List<ClubDto> clubs = clubService.searchClubs(query);
    model.addAttribute("clubs", clubs);
    return "clubs-list";
  }

}
