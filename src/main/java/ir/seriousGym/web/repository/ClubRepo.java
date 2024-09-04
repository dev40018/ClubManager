package ir.seriousGym.web.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ir.seriousGym.web.model.Club;

public interface ClubRepo extends JpaRepository<Club, Long>{
  Optional<Club> findByTitle(String title);

  @Query("SELECT c FROM Club c WHERE c.title LIKE CONCAT('%', :query, '%')")
  List<Club> serachClubs(String query);
}
