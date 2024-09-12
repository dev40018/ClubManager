package ir.seriousGym.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ir.seriousGym.web.dto.RegistrationDto;
import ir.seriousGym.web.model.UserEntity;
import ir.seriousGym.web.service.UserService;
import jakarta.validation.Valid;



@Controller
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/register")
    public String registerForm(Model model) {
        // Spring MVC offers to create such Object for avoiding error maybe reference error
        RegistrationDto registrationDto = new RegistrationDto();
        model.addAttribute("user", registrationDto);
        return "register";
    }

    @PostMapping("/register/save")
    public String postMethodName(@Valid @ModelAttribute("user")RegistrationDto user, Model model, BindingResult result) {
        // Checking By Email if there is already an existing User with that email
        UserEntity existingUserByEmail = userService.findByEmail(user.getEmail());
        if(existingUserByEmail != null && 
           existingUserByEmail.getEmail() != null &&
           !existingUserByEmail.getEmail().isEmpty()){
            result.rejectValue("email", "problem with email");
           }
        // Checking By Username if there is already an existing User with that Username
        UserEntity existingUserByUsername = userService.findByUsername(user.getUsername());
        if(existingUserByUsername != null && 
          existingUserByUsername.getUsername() != null &&
          !existingUserByUsername.getUsername().isEmpty()){
            result.rejectValue("username", "problem with username");
        }
        if(result.hasErrors()){
            model.addAttribute("user", user);
        }
        userService.saveUser(user);
        return "redirect:/clubs?success";
    }
    
    
    
}
