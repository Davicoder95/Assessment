package com.hospital.Hospital_assessment.application.mappers;


import com.hospital.Hospital_assessment.application.dtos.request.UserRequest;
import com.hospital.Hospital_assessment.application.dtos.responses.UserResponse;
import com.hospital.Hospital_assessment.domain.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE= Mappers.getMapper(UserMapper.class);

    @Mapping(source = "username", target = "username")
    User toEntity(UserRequest userRequest);
    UserResponse toResponse(User user);
}
