package com.assessment.Prueba_Empleabilidad.application.dtos.responses;

import lombok.Data;

@Data
public class PatientResponse {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String birthdate;
}