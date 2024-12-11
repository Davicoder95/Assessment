package com.riwi.assestment2.application.services;

import com.riwi.assestment2.domain.entities.User;
import com.riwi.assestment2.infrastructure.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Buscar el usuario en la base de datos por su documento (username)
        Optional<User> userOptional = Optional.ofNullable(userRepository.findByName(username));

        // Manejo del caso en que el usuario no sea encontrado
        User user = userOptional.orElseThrow(() ->
                new UsernameNotFoundException("Usuario no encontrado con documento: " + username));

        // Retornar el usuario que implementa UserDetails
        return user;
    }
}