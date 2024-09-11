package ir.seriousGym.web.service;

import ir.seriousGym.web.dto.RegistrationDto;

public interface UserService {
  void saveUser(RegistrationDto registrationDto);
}
