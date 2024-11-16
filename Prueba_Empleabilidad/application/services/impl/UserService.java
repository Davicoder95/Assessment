package com.assessment.Prueba_Empleabilidad.application.services.impl;

import com.assessment.Prueba_Empleabilidad.application.dtos.request.UserRequest;
import com.assessment.Prueba_Empleabilidad.application.mappers.UserMapper;
import com.assessment.Prueba_Empleabilidad.domain.entities.User;
import com.assessment.Prueba_Empleabilidad.domain.enums.Roles;
import com.assessment.Prueba_Empleabilidad.domain.ports.service.IUserService;
import com.assessment.Prueba_Empleabilidad.infrastructure.persistence.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class
UserService implements IUserService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final UserMapper userMapper;  // Mapper para convertir entre DTO y Entity


    @Override
    public User registerUser(UserRequest userDTO) {
        // Mapear el DTO a la entidad User
        User user = userMapper.toEntity(userDTO);

        // Asignar el rol de ADMIN desde el enum
        user.setRole(Roles.ADMIN);

        // Guardar el usuario en la base de datos
        return userRepository.save(user);
    }
    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }


    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
