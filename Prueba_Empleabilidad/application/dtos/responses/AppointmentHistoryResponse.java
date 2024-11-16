package com.assessment.Prueba_Empleabilidad.application.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AppointmentHistoryResponse {
    private Long id;
    private String observations;
}