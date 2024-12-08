package com.hospital.Hospital_assessment.application.dtos.request;

import lombok.Data;

@Data
public class PatientRequest {
    private String name;
    private String email;
    private String phone;
    private String birthdate;
}