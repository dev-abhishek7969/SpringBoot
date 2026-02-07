package httpbasic_demo.com.abhi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import httpbasic_demo.com.abhi.entity.Role;

public interface RolesRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}