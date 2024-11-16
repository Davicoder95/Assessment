package com.assessment.Prueba_Empleabilidad.application.mappers;

import com.assessment.Prueba_Empleabilidad.application.dtos.request.PatientRequest;
import com.assessment.Prueba_Empleabilidad.application.dtos.responses.PatientResponse;
import com.assessment.Prueba_Empleabilidad.domain.entities.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PatientMapper {
    PatientMapper INSTANCE = Mappers.getMapper(PatientMapper.class);

    Patient toEntity (PatientRequest patientRequest);
    PatientResponse toResponse (Patient patient);

}
