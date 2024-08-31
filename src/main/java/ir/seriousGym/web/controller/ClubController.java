package ir.seriousGym.web.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ir.seriousGym.web.dto.ClubDto;
import ir.seriousGym.web.service.ClubService;

//@RestController its Only For RestAPI, doesn't works with views
@Controller
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
    return "clubs-list";
  }
  
}
