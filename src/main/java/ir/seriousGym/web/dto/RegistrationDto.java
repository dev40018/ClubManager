package ir.seriousGym.web.dto;

import java.util.ArrayList;
import java.util.List;

import ir.seriousGym.web.model.Role;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;



@Data

public class RegistrationDto {
    private Long id;

  @NotEmpty(message="should insert Username")
  private String username;
  @NotEmpty(message="should insert password")
  private String password;
  @NotEmpty(message="should insert email")
  private String email;
  private List<Role> roles = new ArrayList<>();
}
