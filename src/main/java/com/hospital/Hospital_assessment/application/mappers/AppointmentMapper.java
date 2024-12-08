package com.hospital.Hospital_assessment.application.mappers;


import com.hospital.Hospital_assessment.application.dtos.request.AppointmentRequest;
import com.hospital.Hospital_assessment.application.dtos.responses.AppointmentResponse;
import com.hospital.Hospital_assessment.domain.entities.Appointment;
import com.hospital.Hospital_assessment.domain.entities.Doctor;
import com.hospital.Hospital_assessment.domain.entities.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "doctor", source = "doctor")
    @Mapping(target = "patient", source = "patient")
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "availability", ignore = true) // Ignorar el campo availability aquí si se asigna manualmente
    Appointment toEntity(AppointmentRequest appointmentRequest, Doctor doctor, Patient patient);

    AppointmentResponse toResponse(Appointment appointment);
}


