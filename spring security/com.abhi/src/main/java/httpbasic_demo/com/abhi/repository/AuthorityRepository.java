package httpbasic_demo.com.abhi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import httpbasic_demo.com.abhi.entity.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    Optional<Authority> findByName(String name);
}