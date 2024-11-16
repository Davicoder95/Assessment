package com.assessment.Prueba_Empleabilidad.infrastructure.persistence;

import com.assessment.Prueba_Empleabilidad.domain.entities.Appointment;
import com.assessment.Prueba_Empleabilidad.domain.entities.Doctor;
import com.assessment.Prueba_Empleabilidad.domain.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    // Buscar una cita por el doctor y la fecha y hora
    Optional<Appointment> findByDoctorAndDateTime(Doctor doctor, LocalDateTime dateTime);

    // Buscar una cita por el paciente y la fecha y hora
    Optional<Appointment> findByPatientAndDateTime(Patient patient, LocalDateTime dateTime);

    // Buscar todas las citas por el paciente
    List<Appointment> findByPatientId(Long patientId);

    // Buscar todas las citas por el doctor ID
    List<Appointment> findByDoctorId(Long doctorId);

    List<Appointment> findAll();
}