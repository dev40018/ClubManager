package ir.seriousGym.web.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ir.seriousGym.web.dto.ClubDto;
import ir.seriousGym.web.service.ClubService;

@RestController
public class ClubController {

  private final ClubService clubService;

  public ClubController(ClubService clubService) {
    this.clubService = clubService;
  }

  @GetMapping("/clubs")
  // Model will allow us to put stuff on webpage
  public String listAllClubs(Model model){
    List<ClubDto> clubs = clubService.findAllClubs();
    model.addAttribute("clubs", clubs);
    return "clubs-list.html";
  }
  
}
