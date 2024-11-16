package com.assessment.Prueba_Empleabilidad.application.services.impl;

import com.assessment.Prueba_Empleabilidad.domain.entities.Appointment_history;
import com.assessment.Prueba_Empleabilidad.domain.ports.service.IAppointmentHistoryService;
import com.assessment.Prueba_Empleabilidad.infrastructure.persistence.AppointmentHistoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AppointmentHistoryService implements IAppointmentHistoryService {

    @Autowired
    private final AppointmentHistoryRepository appointmentHistoryRepository;

    @Override
    public Appointment_history registerHistory(Long patientId, String observations) {
        // Crear una nueva instancia de Appointment_history
        Appointment_history appointmentHistory = new Appointment_history();
        appointmentHistory.setId(patientId);
        appointmentHistory.setObservations(observations);

        // Guardar el historial en la base de datos
        return appointmentHistoryRepository.save(appointmentHistory);
    }

    @Override
    public List<Appointment_history> getHistoryByPatient(Long patientId) {
        // Buscar todos los historiales de un paciente
        List<Appointment_history> histories = appointmentHistoryRepository.findByPatientId(patientId);

        if (histories.isEmpty()) {
            throw new RuntimeException("No se encontró historial para el paciente con ID: " + patientId);
        }

        return histories; // Devuelve todos los historiales
    }
}
