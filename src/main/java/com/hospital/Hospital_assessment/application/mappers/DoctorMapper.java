package com.hospital.Hospital_assessment.application.mappers;


import com.hospital.Hospital_assessment.application.dtos.request.DoctorRequest;
import com.hospital.Hospital_assessment.application.dtos.responses.DoctorResponse;
import com.hospital.Hospital_assessment.domain.entities.Doctor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DoctorMapper {
    DoctorMapper INSTANCE= Mappers.getMapper(DoctorMapper.class);

    Doctor toEntiy(DoctorRequest doctorRequest);
    DoctorResponse toResponse (Doctor doctor);

}
