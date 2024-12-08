package com.hospital.Hospital_assessment.application.dtos.request;

import lombok.Data;

@Data
public class DoctorRequest {
    private String name;
    private String specialty;
    private String email;
    private String phone;
    private String startTime;
    private String endTime;
}