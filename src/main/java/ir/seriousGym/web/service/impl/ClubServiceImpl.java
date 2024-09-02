package ir.seriousGym.web.service.impl;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import ir.seriousGym.web.dto.ClubDto;
import ir.seriousGym.web.model.Club;
import ir.seriousGym.web.repository.ClubRepo;
import ir.seriousGym.web.service.ClubService;

@Service
public class ClubServiceImpl implements ClubService {

  private final ClubRepo clubRepo;
  
  public ClubServiceImpl(ClubRepo clubRepo) {
    this.clubRepo = clubRepo;
  }

  // must change the method visibility to public for OverRiding
  @Override
  public List<ClubDto> findAllClubs(){
    List<Club> clubs = clubRepo.findAll();
    return clubs.stream()
    .map(club -> mapToClubDto(club)).collect(Collectors.toList());
  }


  // -- Mappers 
  private ClubDto mapToClubDto(Club club){
    ClubDto clubDto = ClubDto.builder()
    .id(club.getId())
    .title(club.getTitle())
    .photoUrl(club.getPhotoUrl())
    .content(club.getContent())
    .createdOn(club.getCreatedOn())
    .updateOn(club.getUpdateOn())
    .build();
    return clubDto;
  }

  private Club mapToClub(ClubDto clubDto){
    Club club = Club.builder()
    .id(clubDto.getId())
    .title(clubDto.getTitle())
    .photoUrl(clubDto.getPhotoUrl())
    .content(clubDto.getContent())
    .createdOn(clubDto.getCreatedOn())
    .updateOn(clubDto.getUpdateOn())
    .build();
    return club;
  }
    // -- Mappers 

  @Override
  public Club saveClub(ClubDto clubDto) {
    Club club = mapToClub(clubDto);
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
    Club club = mapToClub(clubDto);
    clubRepo.save(club);
  }
}
