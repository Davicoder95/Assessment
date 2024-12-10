package com.riwi.assestment2.infrastructure.persistence;

import com.riwi.assestment2.domain.entities.Medical_History;
import com.riwi.assestment2.domain.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicalHistoryRepository extends JpaRepository<Medical_History,Long> {
    List<Medical_History> findByPatient(Patient patient);
}
