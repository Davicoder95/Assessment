package com.assessment.Prueba_Empleabilidad.domain.ports.service;
import com.assessment.Prueba_Empleabilidad.application.dtos.request.UserRequest;
import com.assessment.Prueba_Empleabilidad.domain.entities.User;

import java.util.List;


public interface IUserService  {
    User registerUser(UserRequest userDTO);
    User findUserById(Long id);
    List<User> getAllUsers();
}
