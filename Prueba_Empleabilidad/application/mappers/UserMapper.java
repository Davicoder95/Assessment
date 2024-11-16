package com.assessment.Prueba_Empleabilidad.application.mappers;

import com.assessment.Prueba_Empleabilidad.application.dtos.request.UserRequest;
import com.assessment.Prueba_Empleabilidad.application.dtos.responses.UserResponse;
import com.assessment.Prueba_Empleabilidad.domain.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE= Mappers.getMapper(UserMapper.class);

    @Mapping(source = "username", target = "username")
    User toEntity(UserRequest userRequest);
    UserResponse toResponse( User user);
}
