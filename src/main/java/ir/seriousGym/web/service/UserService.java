package ir.seriousGym.web.service;

import ir.seriousGym.web.dto.RegistrationDto;
import ir.seriousGym.web.model.UserEntity;

public interface UserService {
  void saveUser(RegistrationDto registrationDto);

  UserEntity findByEmail(String email);

  UserEntity findByUsername(String username);
}
