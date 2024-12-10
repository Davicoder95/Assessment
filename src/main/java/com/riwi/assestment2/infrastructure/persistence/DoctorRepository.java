package com.riwi.assestment2.infrastructure.persistence;

import com.riwi.assestment2.domain.entities.Doctor;
import com.riwi.assestment2.domain.enums.StatusMedic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    List<Doctor> findBySpeciality(String speciality);
    List<Doctor> findByStatus(StatusMedic status);
}
