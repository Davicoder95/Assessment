package com.assessment.Prueba_Empleabilidad.application.dtos.request;

import com.assessment.Prueba_Empleabilidad.domain.enums.Roles;
import lombok.Data;

@Data
public class UserRequest {
    private String username;
    private String email;
    private String password;
    private String phone;
    private String address;
    private Roles role;
}