package ir.seriousGym.web.service;

// think about Sealed interface

import java.util.List;

import ir.seriousGym.web.dto.ClubDto;
import ir.seriousGym.web.model.Club;



public interface ClubService {
  List<ClubDto> findAllClubs();
  Club saveClub(ClubDto clubDto);
  ClubDto findClubById(long clubId);
  void updateClub(ClubDto clubDto);
}
