package com.hospital.Hospital_assessment.application.dtos.request;

import lombok.Data;

@Data
public class UserRequest {
    private String username;
    private String email;
    private String password;
    private String phone;
    private String address;

}