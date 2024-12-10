package com.riwi.assestment2.infrastructure.persistence;

import com.riwi.assestment2.domain.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
