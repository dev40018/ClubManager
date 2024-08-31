package ir.seriousGym.web.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ir.seriousGym.web.model.Club;

public interface ClubRepo extends JpaRepository<Club, Long>{
  Optional<Club> findByTitle(String title);
}
