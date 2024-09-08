package ir.seriousGym.web.mapper;


import java.util.stream.Collectors;

import ir.seriousGym.web.dto.ClubDto;
import static ir.seriousGym.web.mapper.EventMapper.mapToEventDto;
import ir.seriousGym.web.model.Club;

public class ClubMapper {

  public static ClubDto mapToClubDto(Club club){
    ClubDto clubDto = ClubDto.builder()
    .id(club.getId())
    .title(club.getTitle())
    .photoUrl(club.getPhotoUrl())
    .content(club.getContent())
    .createdOn(club.getCreatedOn())
    .updateOn(club.getUpdateOn())
    .events(club.getEvents().stream().map(event -> mapToEventDto(event)).collect(Collectors.toList()))
    .build();
    return clubDto;
  }

  public static Club mapToClub(ClubDto clubDto){
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
  
}
