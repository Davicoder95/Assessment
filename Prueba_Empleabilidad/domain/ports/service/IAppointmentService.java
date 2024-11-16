package com.assessment.Prueba_Empleabilidad.domain.ports.service;

import com.assessment.Prueba_Empleabilidad.application.dtos.request.AppointmentRequest;
import com.assessment.Prueba_Empleabilidad.application.dtos.responses.AppointmentResponse;

import java.util.List;

public interface IAppointmentService {
    AppointmentResponse registerAppointment(AppointmentRequest appointmentDTO);
    List<AppointmentResponse> getAllAppointments();
    List<AppointmentResponse> getAppointmentsByPatient(Long patientId);
    List<AppointmentResponse> getAppointmentsByDoctor(Long doctorId);

}
