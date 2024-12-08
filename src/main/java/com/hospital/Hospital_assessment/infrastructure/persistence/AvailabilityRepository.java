package com.hospital.Hospital_assessment.infrastructure.persistence;


import com.hospital.Hospital_assessment.domain.entities.Availability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface AvailabilityRepository extends JpaRepository<Availability, Long> {
    // Consulta para obtener las disponibilidades por doctor y un rango de fechas
    List<Availability> findByDoctorIdAndDateBetween(Long doctorId, LocalDateTime startDate, LocalDateTime endDate);

    // Consulta para obtener todas las disponibilidades de un doctor
    List<Availability> findAllByDoctorId(Long doctorId);

    // Consulta para verificar si un doctor tiene disponibilidad en un horario específico

    Optional<Availability> findFirstByDoctorIdAndDateAndStartTimeLessThanEqualAndEndTimeGreaterThanEqual(
            Long doctorId, LocalDate date, LocalTime startTime, LocalTime endTime
    );

    boolean existsByDoctorIdAndDateAndStartTimeBeforeAndEndTimeAfter(Long doctorId, LocalDate date, LocalTime endTime, LocalTime startTime);
}