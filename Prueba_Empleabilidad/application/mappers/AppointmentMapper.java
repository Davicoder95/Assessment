package com.assessment.Prueba_Empleabilidad.application.mappers;

import com.assessment.Prueba_Empleabilidad.application.dtos.request.AppointmentRequest;
import com.assessment.Prueba_Empleabilidad.application.dtos.responses.AppointmentResponse;
import com.assessment.Prueba_Empleabilidad.domain.entities.Appointment;
import com.assessment.Prueba_Empleabilidad.domain.entities.Doctor;
import com.assessment.Prueba_Empleabilidad.domain.entities.Patient;
import com.assessment.Prueba_Empleabilidad.domain.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {
    AppointmentMapper INSTANCE = Mappers.getMapper(AppointmentMapper.class);

    @Mapping(target = "id", ignore = true)  // Ignorar el ID en la conversión a entidad, ya que lo generará la base de datos
    @Mapping(target = "doctor", source = "doctor")  // Asegurar que el doctor sea asignado correctamente
    @Mapping(target = "patient", source = "patient")  // Asegurar que el paciente sea asignado correctamente
    @Mapping(target = "user", source = "user")
    Appointment toEntity(AppointmentRequest appointmentRequest, Doctor doctor, Patient patient, User user);
    AppointmentResponse toResponse (Appointment appointment);

}
