package ir.seriousGym.web.service.impl;

import java.util.Arrays;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ir.seriousGym.web.dto.RegistrationDto;
import ir.seriousGym.web.model.Role;
import ir.seriousGym.web.model.UserEntity;
import ir.seriousGym.web.repository.RoleRepo;
import ir.seriousGym.web.repository.UserRepo;
import ir.seriousGym.web.service.UserService;

@Service
public class UserServiceImpl implements UserService {
  private final UserRepo userRepo;
  private final RoleRepo roleRepo;
  private final PasswordEncoder passwordEncoder;
  public UserServiceImpl(UserRepo userRepo, RoleRepo roleRepo, PasswordEncoder passwordEncoder) {
    this.userRepo = userRepo;
    this.roleRepo = roleRepo;
    this.passwordEncoder = passwordEncoder;
  }
  @Override
  public void saveUser(RegistrationDto registrationDto) {
    // first we make an object then fill it with upcomming detials
    UserEntity user = new UserEntity();
    user.setUsername(registrationDto.getUsername());
    user.setEmail(registrationDto.getEmail());
    // encoding the password in BCryptFormat
    user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
    // then we need to Create a Role to Populate our user with it
    // you can make a user Admin by editing it within DB DML
    Role role = roleRepo.findByName("USER");
    // it can have 1 or multiple role that why its list
    user.setRoles(Arrays.asList(role));
    userRepo.save(user);
  }
  @Override
  public UserEntity findByEmail(String email) {
    return userRepo.findByEmail(email);
  }
  @Override
  public UserEntity findByUsername(String username) {
    return userRepo.findByUsername(username);
  }
  
}
