package ir.seriousGym.web.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ir.seriousGym.web.model.UserEntity;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Long> {
  UserEntity findByEmail(String email);
  UserEntity findByUsername(String username);
  //is a convention-based query method that is used to retrieve the first entity from the database that
  // matches a specified condition—in this case, the username.
  // SELECT * FROM users WHERE username = 'someUsername' LIMIT 1;
  UserEntity findFirstByUsername(String username);
}
