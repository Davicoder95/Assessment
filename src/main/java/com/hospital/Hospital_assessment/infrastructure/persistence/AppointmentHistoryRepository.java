package com.hospital.Hospital_assessment.infrastructure.persistence;


import com.hospital.Hospital_assessment.domain.entities.Appointment_history;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentHistoryRepository extends JpaRepository<Appointment_history, Long> {
    // Aquí puedes agregar consultas personalizadas si es necesario
    List<Appointment_history> findByPatientId(Long patientId);
}