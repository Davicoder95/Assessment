package com.assessment.Prueba_Empleabilidad.controllers;


import com.assessment.Prueba_Empleabilidad.application.dtos.request.AvailabilityRequest;
import com.assessment.Prueba_Empleabilidad.application.dtos.responses.AvailabilityResponse;
import com.assessment.Prueba_Empleabilidad.application.mappers.AvailabilityMapper;
import com.assessment.Prueba_Empleabilidad.domain.entities.Availability;
import com.assessment.Prueba_Empleabilidad.domain.ports.service.IAvailabilityService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/availabilities")
@AllArgsConstructor
public class AvailabilityController {

    @Autowired
    private final IAvailabilityService availabilityService;
    @Autowired
    private final AvailabilityMapper availabilityMapper;


    @PostMapping("/register/{doctorId}")
    public ResponseEntity<AvailabilityResponse> registerAvailability(
            @PathVariable Long doctorId,
            @RequestBody AvailabilityRequest availabilityRequest) {
        Availability availability = availabilityService.registerAvailability(doctorId, availabilityRequest);
        AvailabilityResponse response = availabilityMapper.toResponse(availability);  // Asumiendo que tienes un mapper para convertir a Response
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    // Método para obtener todas las disponibilidades de un doctor
    @GetMapping("allAvailabilities/{doctorId}")
    public ResponseEntity<List<AvailabilityResponse>> getAvailabilitiesByDoctor(@PathVariable Long doctorId) {
        List<Availability> availabilities = availabilityService.getAvailabilitiesByDoctor(doctorId);
        List<AvailabilityResponse> response = availabilities.stream()
                .map(availabilityMapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }
    // Método para obtener disponibilidades de un doctor dentro de un rango de fechas
    @GetMapping("/range/{doctorId}/range")
    public ResponseEntity<List<AvailabilityResponse>> getAvailabilitiesByDoctorAndDateRange(
            @PathVariable Long doctorId,
            @RequestParam LocalDateTime startDate,
            @RequestParam LocalDateTime endDate) {
        List<Availability> availabilities = availabilityService.getAvailabilitiesByDoctorAndDateRange(doctorId, startDate, endDate);
        List<AvailabilityResponse> response = availabilities.stream()
                .map(availabilityMapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }
}