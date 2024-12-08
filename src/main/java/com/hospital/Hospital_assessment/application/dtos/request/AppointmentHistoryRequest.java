package com.hospital.Hospital_assessment.application.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AppointmentHistoryRequest {
    private Long patientId;
    private String observations;
}