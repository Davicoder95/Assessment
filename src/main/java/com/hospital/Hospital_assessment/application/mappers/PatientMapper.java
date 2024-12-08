package com.hospital.Hospital_assessment.application.mappers;


import com.hospital.Hospital_assessment.application.dtos.request.PatientRequest;
import com.hospital.Hospital_assessment.application.dtos.responses.PatientResponse;
import com.hospital.Hospital_assessment.domain.entities.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PatientMapper {
    PatientMapper INSTANCE = Mappers.getMapper(PatientMapper.class);

    Patient toEntity (PatientRequest patientRequest);
    PatientResponse toResponse (Patient patient);

}
