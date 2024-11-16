package com.assessment.Prueba_Empleabilidad.application.mappers;

import com.assessment.Prueba_Empleabilidad.application.dtos.request.AppointmentHistoryRequest;
import com.assessment.Prueba_Empleabilidad.application.dtos.responses.AppointmentHistoryResponse;
import com.assessment.Prueba_Empleabilidad.domain.entities.Appointment_history;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AppointmentHistoryMapper {
    AppointmentHistoryMapper INSTANCE = Mappers.getMapper(AppointmentHistoryMapper.class);

    Appointment_history toentity (AppointmentHistoryRequest appointmenthistoryRequest);
    AppointmentHistoryResponse toResponse (Appointment_history appointmentHistory);
}
