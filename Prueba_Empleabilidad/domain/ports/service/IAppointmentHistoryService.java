package com.assessment.Prueba_Empleabilidad.domain.ports.service;

import com.assessment.Prueba_Empleabilidad.domain.entities.Appointment_history;

import java.util.List;

public interface IAppointmentHistoryService {
    Appointment_history registerHistory(Long patientId, String observations);
    List<Appointment_history> getHistoryByPatient(Long patientId);
}
