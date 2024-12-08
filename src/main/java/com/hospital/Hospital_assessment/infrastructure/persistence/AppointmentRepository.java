package com.hospital.Hospital_assessment.infrastructure.persistence;


import com.hospital.Hospital_assessment.domain.entities.Appointment;
import com.hospital.Hospital_assessment.domain.entities.Doctor;
import com.hospital.Hospital_assessment.domain.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    boolean existsByDoctorAndDateTime(Doctor doctor, LocalDateTime dateTime);

    boolean existsByPatientAndDateTime(Patient patient, LocalDateTime dateTime);

    // Buscar todas las citas por el paciente
    List<Appointment> findByPatientId(Long patientId);

    // Buscar todas las citas por el doctor ID
    List<Appointment> findByDoctorId(Long doctorId);

    List<Appointment> findAll();
}