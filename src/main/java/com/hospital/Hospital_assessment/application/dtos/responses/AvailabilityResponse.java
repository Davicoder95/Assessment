package com.hospital.Hospital_assessment.application.dtos.responses;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class AvailabilityResponse {
    private Long id;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
}