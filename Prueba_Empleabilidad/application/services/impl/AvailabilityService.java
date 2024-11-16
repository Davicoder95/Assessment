package com.assessment.Prueba_Empleabilidad.application.services.impl;

import com.assessment.Prueba_Empleabilidad.application.dtos.request.AvailabilityRequest;
import com.assessment.Prueba_Empleabilidad.application.mappers.AvailabilityMapper;
import com.assessment.Prueba_Empleabilidad.domain.entities.Availability;
import com.assessment.Prueba_Empleabilidad.domain.entities.Doctor;
import com.assessment.Prueba_Empleabilidad.domain.ports.service.IAvailabilityService;
import com.assessment.Prueba_Empleabilidad.infrastructure.persistence.AvailabilityRepository;
import com.assessment.Prueba_Empleabilidad.infrastructure.persistence.DoctorRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;


@Service
@AllArgsConstructor
public class AvailabilityService implements IAvailabilityService {

    @Autowired
    private final AvailabilityRepository availabilityRepository;
    @Autowired
    private final DoctorRepository doctorRepository;
    @Autowired
    private final AvailabilityMapper availabilityMapper;



    @Override
    public Availability registerAvailability(Long doctorId, AvailabilityRequest availabilityDTO) {
        // Convertimos la fecha en formato String a LocalDate
        LocalDate date = LocalDate.parse(availabilityDTO.getDate());  // "2024-11-16"

        // Convertimos las horas (String "HH:mm:ss") a LocalTime
        LocalTime startTime = LocalTime.parse(availabilityDTO.getStartTime());  // "12:30:00"
        LocalTime endTime = LocalTime.parse(availabilityDTO.getEndTime());      // "13:50:00"

        // Creamos la entidad Availability
        Availability availability = new Availability();

        // Combinamos la fecha con la hora de inicio y fin para obtener el LocalDateTime
        availability.setDate(date.atTime(startTime));  // "2024-11-16T12:30:00"
        availability.setStartTime(startTime);          // "12:30:00"
        availability.setEndTime(endTime);              // "13:50:00"

        // Recuperamos el doctor de la base de datos
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(() -> new RuntimeException("Doctor not found"));
        availability.setDoctor(doctor);

        // Guardamos la entidad en la base de datos
        return availabilityRepository.save(availability);
    }


    @Override
    public List<Availability> getAvailabilitiesByDoctorAndDateRange(Long doctorId, LocalDateTime startDate, LocalDateTime endDate) {
        // Consultar disponibilidades por doctor y rango de fechas
        return availabilityRepository.findByDoctorIdAndDateBetween(doctorId, startDate, endDate);

    }

    @Override
    public List<Availability> getAvailabilitiesByDoctor(Long doctorId) {
        return availabilityRepository.findAllByDoctorId(doctorId);
    }


}