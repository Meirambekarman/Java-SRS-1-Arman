package kz.kaznitu.lessons.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kz.kaznitu.lessons.models.Role;

@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role, Integer>{
    Role findByRole(String role);

}
