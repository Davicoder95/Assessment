package com.hospital.Hospital_assessment.application.dtos.responses;


import com.hospital.Hospital_assessment.domain.enums.Roles;
import lombok.Data;

@Data
public class UserResponse {
    private Long id;
    private String username;
    private String email;
    private String phone;
    private String address;
    private Roles role;
}