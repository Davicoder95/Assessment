package com.assessment.Prueba_Empleabilidad.application.dtos.responses;

import com.assessment.Prueba_Empleabilidad.domain.enums.Roles;
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