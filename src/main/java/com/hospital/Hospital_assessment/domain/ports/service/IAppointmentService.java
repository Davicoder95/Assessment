package com.hospital.Hospital_assessment.domain.ports.service;



import com.hospital.Hospital_assessment.application.dtos.request.AppointmentRequest;
import com.hospital.Hospital_assessment.application.dtos.responses.AppointmentResponse;

import java.util.List;

public interface IAppointmentService {
    AppointmentResponse registerAppointment(AppointmentRequest appointmentDTO);
    List<AppointmentResponse> getAllAppointments();
    List<AppointmentResponse> getAppointmentsByPatient(Long patientId);
    List<AppointmentResponse> getAppointmentsByDoctor(Long doctorId);

}
