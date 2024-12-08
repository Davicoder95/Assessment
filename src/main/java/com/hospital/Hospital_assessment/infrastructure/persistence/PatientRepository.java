package com.hospital.Hospital_assessment.infrastructure.persistence;

import com.hospital.Hospital_assessment.domain.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    Optional<Patient> findById(Long id);

    List<Patient> findAll();
}