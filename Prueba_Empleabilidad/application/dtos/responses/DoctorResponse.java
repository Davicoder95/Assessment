package com.assessment.Prueba_Empleabilidad.application.dtos.responses;

import lombok.Data;

@Data
public class DoctorResponse {
    private Long id;
    private String name;
    private String specialty;
    private String email;
    private String phone;
    private String startTime;
    private String endTime;
}