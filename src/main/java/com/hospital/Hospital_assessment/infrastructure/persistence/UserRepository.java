package com.hospital.Hospital_assessment.infrastructure.persistence;


import com.hospital.Hospital_assessment.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findById(Long id);
    List<User> findAll();
    Optional<User> findByUsername(String username);
}