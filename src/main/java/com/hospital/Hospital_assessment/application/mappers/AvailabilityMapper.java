package com.hospital.Hospital_assessment.application.mappers;


import com.hospital.Hospital_assessment.application.dtos.request.AvailabilityRequest;
import com.hospital.Hospital_assessment.application.dtos.responses.AvailabilityResponse;
import com.hospital.Hospital_assessment.domain.entities.Availability;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AvailabilityMapper {
    AvailabilityMapper INSTANCE = Mappers.getMapper(AvailabilityMapper.class);

    @Mapping(target = "date", source = "date")
    Availability toEntity (AvailabilityRequest availabilityRequest);

    @Mapping(target = "date", source = "date")
    AvailabilityResponse toResponse (Availability availability);
}
