package ir.seriousGym.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ir.seriousGym.web.model.Event;

@Repository
public interface EventRepo extends JpaRepository<Event, Long> {
  
}
