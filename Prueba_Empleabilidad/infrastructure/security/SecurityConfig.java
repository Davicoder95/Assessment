package com.assessment.Prueba_Empleabilidad.infrastructure.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity // Habilita la configuración de seguridad
@AllArgsConstructor // Genera un constructor
@Configuration // Indica que esta clase es una clase de configuración
public class SecurityConfig {

    private final JwtFilter jwtFilter; // Filtro para manejar la autenticación JWT

    private final AuthenticationProvider authenticationProvider; // Proveedor de autenticación para manejar las credenciales

    // Definición de los endpoints públicos
    private final String[] PUBLIC_ENDPOINTS = {
            "/swagger-ui/**",
            "/v3/api-docs/**",
            "/api/users/**",
            "/patients/**",
            "/doctors/**",
            "/availabilities/**",
            "/appointments/**",
            "/appointment-history/**"

    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable()) // Desactiva CSRF ya que se usará JWT
                .authorizeHttpRequests(authRequest -> authRequest
                        .requestMatchers(PUBLIC_ENDPOINTS).permitAll() // Permite acceso a todos a los endpoints públicos
                        .anyRequest().authenticated()) // Cualquier otra solicitud requiere autenticación
                .authenticationProvider(authenticationProvider) // Establece el proveedor de autenticación
                .sessionManagement(sessionManager -> sessionManager.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Configura la sesión para que sea sin estado
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class) // Agrega el filtro JWT antes del filtro de autenticación por nombre de usuario y contraseña
                .build(); // Construye la cadena de seguridad
    }
}