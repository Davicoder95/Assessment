package com.assessment.Prueba_Empleabilidad.application.dtos.request;

import com.assessment.Prueba_Empleabilidad.domain.enums.StatusDates;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentRequest {
    private LocalDateTime dateTime;
    private String comments;
    private Long doctorId;
    private Long patientId;
}