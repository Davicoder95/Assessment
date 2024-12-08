package com.hospital.Hospital_assessment.application.mappers;

import com.hospital.Hospital_assessment.application.dtos.request.AppointmentHistoryRequest;
import com.hospital.Hospital_assessment.application.dtos.responses.AppointmentHistoryResponse;
import com.hospital.Hospital_assessment.domain.entities.Appointment_history;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AppointmentHistoryMapper {
    AppointmentHistoryMapper INSTANCE = Mappers.getMapper(AppointmentHistoryMapper.class);

    Appointment_history toentity (AppointmentHistoryRequest appointmenthistoryRequest);
    AppointmentHistoryResponse toResponse (Appointment_history appointmentHistory);
}
