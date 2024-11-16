package com.assessment.Prueba_Empleabilidad.infrastructure.persistence;

import com.assessment.Prueba_Empleabilidad.domain.entities.Availability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AvailabilityRepository extends JpaRepository<Availability, Long> {
    // Consulta para obtener las disponibilidades por doctor y fecha
    List<Availability> findByDoctorIdAndDateBetween(Long doctorId, LocalDateTime startDate, LocalDateTime endDate);
    List<Availability> findAllByDoctorId(Long doctorId);
}