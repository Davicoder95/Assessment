package com.assessment.Prueba_Empleabilidad.domain.ports.service;

import com.assessment.Prueba_Empleabilidad.application.dtos.request.AvailabilityRequest;
import com.assessment.Prueba_Empleabilidad.domain.entities.Availability;

import java.time.LocalDateTime;
import java.util.List;

public interface IAvailabilityService {
    // Métodos específicos para la entidad Availability
    Availability registerAvailability(Long doctorId, AvailabilityRequest availabilityDTO);
    List<Availability> getAvailabilitiesByDoctorAndDateRange(Long doctorId, LocalDateTime startDate, LocalDateTime endDate);
    // Obtener todas las disponibilidades de un doctor
    List<Availability> getAvailabilitiesByDoctor(Long doctorId);
}
