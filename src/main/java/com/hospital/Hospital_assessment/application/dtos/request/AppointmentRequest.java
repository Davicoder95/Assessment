package com.hospital.Hospital_assessment.application.dtos.request;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class AppointmentRequest {
    private LocalDate date;
    private String startTime;
    private String endTime;
    private Long doctorId;
    private Long patientId;
}