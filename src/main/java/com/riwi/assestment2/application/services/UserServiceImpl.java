package com.riwi.assestment2.application.services;


import com.riwi.assestment2.application.dtos.request.UserRequestDto;
import com.riwi.assestment2.application.dtos.response.AuthResponseDto;
import com.riwi.assestment2.application.dtos.response.UserResponseDto;
import com.riwi.assestment2.domain.entities.User;
import com.riwi.assestment2.domain.enums.Roles;
import com.riwi.assestment2.domain.ports.service.interfaces.IUserService;
import com.riwi.assestment2.infrastructure.persistence.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public List<UserResponseDto> readAll() {
        List<User> userList = userRepository.findAll();

        return null;
    }

    @Override
    public UserResponseDto readById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return null;
    }

    public User update(UserRequestDto userRequestDto, Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        user.setName(userRequestDto.getName());

        if (userRequestDto.getPassword() != null && !userRequestDto.getPassword().isEmpty()) {
            user.setPassword(passwordEncoder.encode(userRequestDto.getPassword()));
        }
        return userRepository.save(user);
    }

    @Override
    public AuthResponseDto register(UserRequestDto request, Roles role) {
        User userDB = userRepository.findByName(request.getName());

        if(userDB != null){
            throw new UsernameNotFoundException("Username register");
        }

        User user = User.builder()
                .name(request.getName())
                .document(request.getDocument())
                .password(this.passwordEncoder.encode(request.getPassword()))
                .role(role)
                .build();


        user = this.userRepository.save(user);

        return AuthResponseDto.builder()
                .message(user.getRole() + " successfully authenticated")
                //.token(this.jwtUtil.generateToken(user))
                .id(user.getId())
                .name(user.getUsername())
                .role(user.getRole().name())
                .build();
    }

    @Override
    public User getEntityById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with id: " + id));
    }

}
