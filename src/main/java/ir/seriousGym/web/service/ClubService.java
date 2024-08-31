package ir.seriousGym.web.service;

// think about Sealed interface

import java.util.List;

import ir.seriousGym.web.dto.ClubDto;


public interface ClubService {
  List<ClubDto> findAllClubs();
}
