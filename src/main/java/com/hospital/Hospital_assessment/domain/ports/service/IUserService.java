package com.hospital.Hospital_assessment.domain.ports.service;


import com.hospital.Hospital_assessment.application.dtos.request.UserRequest;
import com.hospital.Hospital_assessment.domain.entities.User;


import java.util.List;


public interface IUserService  {
    User registerUser(UserRequest userDTO);
    User findUserById(Long id);
    List<User> getAllUsers();
}
