package com.assessment.Prueba_Empleabilidad.application.dtos.responses;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class AvailabilityResponse {
    private Long id;
    private LocalDateTime date;
    private LocalTime startTime;
    private LocalTime endTime;
}