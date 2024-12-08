package com.hospital.Hospital_assessment.application.dtos.request;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class AvailabilityRequest {
    private String date;          // La fecha solo como String (ej. "2024-11-16")
    private String startTime;     // Hora de inicio en formato "HH:mm:ss"
    private String endTime;       // Hora de fin en formato "HH:mm:ss"
    private Long doctorId;        // Identificador del doctor

}