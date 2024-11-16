package com.assessment.Prueba_Empleabilidad.application.mappers;

import com.assessment.Prueba_Empleabilidad.application.dtos.request.DoctorRequest;
import com.assessment.Prueba_Empleabilidad.application.dtos.responses.DoctorResponse;
import com.assessment.Prueba_Empleabilidad.domain.entities.Doctor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DoctorMapper {
    DoctorMapper INSTANCE= Mappers.getMapper(DoctorMapper.class);

    Doctor toEntiy(DoctorRequest doctorRequest);
    DoctorResponse toResponse (Doctor doctor);

}
