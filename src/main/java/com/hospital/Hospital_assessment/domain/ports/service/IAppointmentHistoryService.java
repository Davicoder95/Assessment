package com.hospital.Hospital_assessment.domain.ports.service;



import com.hospital.Hospital_assessment.domain.entities.Appointment_history;

import java.util.List;

public interface IAppointmentHistoryService {
    Appointment_history registerHistory(Long patientId, String observations);
    List<Appointment_history> getHistoryByPatient(Long patientId);
}
