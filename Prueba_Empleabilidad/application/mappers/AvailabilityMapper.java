package com.assessment.Prueba_Empleabilidad.application.mappers;

import com.assessment.Prueba_Empleabilidad.application.dtos.request.AvailabilityRequest;
import com.assessment.Prueba_Empleabilidad.application.dtos.responses.AvailabilityResponse;
import com.assessment.Prueba_Empleabilidad.domain.entities.Availability;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AvailabilityMapper {
    AvailabilityMapper INSTANCE = Mappers.getMapper(AvailabilityMapper.class);

    Availability toEntity (AvailabilityRequest availabilityRequest);
    AvailabilityResponse toResponse (Availability availability);
}
