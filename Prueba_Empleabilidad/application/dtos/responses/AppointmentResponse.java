package com.assessment.Prueba_Empleabilidad.application.dtos.responses;

import com.assessment.Prueba_Empleabilidad.domain.enums.StatusDates;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class AppointmentResponse {
    private Long id;
    private StatusDates status;
    private String comments;
    private String message;

}