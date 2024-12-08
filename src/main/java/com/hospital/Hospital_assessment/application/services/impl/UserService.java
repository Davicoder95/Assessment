package com.hospital.Hospital_assessment.application.services.impl;

import com.hospital.Hospital_assessment.application.dtos.request.UserRequest;
import com.hospital.Hospital_assessment.application.mappers.UserMapper;
import com.hospital.Hospital_assessment.domain.entities.User;
import com.hospital.Hospital_assessment.domain.enums.Roles;
import com.hospital.Hospital_assessment.domain.ports.service.IUserService;
import com.hospital.Hospital_assessment.infrastructure.persistence.UserRepository;
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
