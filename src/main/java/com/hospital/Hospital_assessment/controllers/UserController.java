package com.hospital.Hospital_assessment.controllers;

import com.hospital.Hospital_assessment.application.dtos.request.UserRequest;
import com.hospital.Hospital_assessment.application.services.impl.UserService;
import com.hospital.Hospital_assessment.domain.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Registra un nuevo usuario con el rol ADMIN.
     *
     * @param userDTO Datos del usuario para el registro.
     * @return Respuesta con el usuario registrado.
     */
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody UserRequest userDTO) {
        User registeredUser = userService.registerUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(registeredUser);
    }

    /**
     * Obtiene un usuario por su ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.findUserById(id);
        return ResponseEntity.ok(user);
    }

    /**
     * Obtiene todos los usuarios registrados.
     *
     * @return Lista de usuarios.
     */
    @GetMapping("Allusers")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
}
