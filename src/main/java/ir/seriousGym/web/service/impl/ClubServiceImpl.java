package ir.seriousGym.web.service.impl;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import ir.seriousGym.web.dto.ClubDto;
import static ir.seriousGym.web.mapper.ClubMapper.mapToClub;
import static ir.seriousGym.web.mapper.ClubMapper.mapToClubDto;
import ir.seriousGym.web.model.Club;
import ir.seriousGym.web.model.UserEntity;
import ir.seriousGym.web.repository.ClubRepo;
import ir.seriousGym.web.repository.UserRepo;
import ir.seriousGym.web.security.SecurityUtil;
import ir.seriousGym.web.service.ClubService;



@Service
public class ClubServiceImpl implements ClubService {

  private final ClubRepo clubRepo;
  private final UserRepo userRepo;
  
  public ClubServiceImpl(ClubRepo clubRepo, UserRepo userRepo) {
    this.clubRepo = clubRepo;
    this.userRepo = userRepo;
  }

  // must change the method visibility to public for OverRiding
  @Override
  public List<ClubDto> findAllClubs(){
    List<Club> clubs = clubRepo.findAll();
    return clubs.stream()
    .map(club -> mapToClubDto(club)).collect(Collectors.toList());
  }



  @Override
  public Club saveClub(ClubDto clubDto) {
    // checking the session
    String username =SecurityUtil.getUserBySession();
    UserEntity user = userRepo.findByUsername(username);
    Club club = mapToClub(clubDto);
    club.setCreatedBy(user);
    return clubRepo.save(club);
  }

  @Override
  public ClubDto findClubById(long clubId) {
    Club club = clubRepo.findById(clubId).get();
    // in here get() method only return Club object
    // if you don't use it, will return Optional
    return mapToClubDto(club);
  }

  @Override
  public void updateClub(ClubDto clubDto) {
    String username =SecurityUtil.getUserBySession();
    UserEntity user = userRepo.findByUsername(username);
    Club club = mapToClub(clubDto);
    club.setCreatedBy(user);
    clubRepo.save(club);
  }

  @Override
  public void deleteClub(long clubId) {
   clubRepo.deleteById(clubId);
  }

  @Override
  public List<ClubDto> searchClubs(String query) {
    List<Club> foundClubs = clubRepo.serachClubs(query);
    return foundClubs.stream()
    .map(foundClub -> mapToClubDto(foundClub))
    .collect(Collectors.toList());
  }
}
