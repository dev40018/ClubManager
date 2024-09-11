package ir.seriousGym.web.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ir.seriousGym.web.model.UserEntity;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Long> {
  UserEntity findByEmail(String email);
  UserEntity findByUsername(String username);
}
