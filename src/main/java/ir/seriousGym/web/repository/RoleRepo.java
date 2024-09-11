package ir.seriousGym.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ir.seriousGym.web.model.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long>{
  Role findByName(String name);
}
