package com.assessment.Prueba_Empleabilidad.controllers;

import com.assessment.Prueba_Empleabilidad.application.dtos.request.AppointmentHistoryRequest;
import com.assessment.Prueba_Empleabilidad.application.dtos.responses.AppointmentHistoryResponse;
import com.assessment.Prueba_Empleabilidad.application.services.impl.AppointmentHistoryService;
import com.assessment.Prueba_Empleabilidad.domain.entities.Appointment_history;
import com.assessment.Prueba_Empleabilidad.domain.ports.service.IAppointmentHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/appointment-history")
@RequiredArgsConstructor
public class AppointmentHistoryController {

    @Autowired
    private final AppointmentHistoryService appointmentHistoryService;

    // Endpoint para registrar el historial de citas de un paciente
    @PostMapping
    public ResponseEntity<AppointmentHistoryResponse> registerHistory(@RequestBody AppointmentHistoryRequest appointmentHistoryRequest) {
        try {
            // Registrar el historial
            Appointment_history appointmentHistory = appointmentHistoryService.registerHistory(
                    appointmentHistoryRequest.getPatientId(),
                    appointmentHistoryRequest.getObservations()
            );

            // Crear la respuesta del historial
            AppointmentHistoryResponse appointmentHistoryResponse = new AppointmentHistoryResponse(
                    appointmentHistory.getId(),
                    appointmentHistory.getObservations()
            );

            return new ResponseEntity<>(appointmentHistoryResponse, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // Endpoint para obtener el historial de citas de un paciente
    @GetMapping("/{patientId}")
    public ResponseEntity<List<AppointmentHistoryResponse>> getHistoryByPatient(@PathVariable Long patientId) {
        try {
            // Obtener todos los historiales de citas del paciente
            List<Appointment_history> histories = appointmentHistoryService.getHistoryByPatient(patientId);

            // Convertir los historiales a las respuestas DTO
            List<AppointmentHistoryResponse> response = histories.stream()
                    .map(history -> new AppointmentHistoryResponse(history.getId(), history.getObservations()))
                    .toList();

            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}