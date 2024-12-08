package com.hospital.Hospital_assessment.controllers;

import com.hospital.Hospital_assessment.application.dtos.request.AppointmentRequest;
import com.hospital.Hospital_assessment.application.dtos.responses.AppointmentResponse;
import com.hospital.Hospital_assessment.domain.enums.StatusDates;
import com.hospital.Hospital_assessment.domain.ports.service.IAppointmentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/appointments")
@AllArgsConstructor// Endpoint para las citas
public class AppointmentController {

    @Autowired
    private final IAppointmentService appointmentService;



    // Registrar una nueva cita
    @PostMapping
    public ResponseEntity<AppointmentResponse> registerAppointment(@RequestBody AppointmentRequest appointmentRequest) {
        try {
            AppointmentResponse appointmentResponse = appointmentService.registerAppointment(appointmentRequest);
            return ResponseEntity.ok(appointmentResponse);  // Si la cita se registra correctamente
        } catch (RuntimeException ex) {
            // Crear la respuesta de cita vacía con el mensaje de error
            AppointmentResponse appointmentResponse = new AppointmentResponse(null, StatusDates.Pending, ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(appointmentResponse);  // Retornar el mensaje con código de error 400
        }
    }

    // Obtener todas las citas
    @GetMapping
    public ResponseEntity<List<AppointmentResponse>> getAllAppointments() {
        List<AppointmentResponse> appointments = appointmentService.getAllAppointments();
        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }

    // Obtener citas por paciente
    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<AppointmentResponse>> getAppointmentsByPatient(@PathVariable Long patientId) {
        List<AppointmentResponse> appointments = appointmentService.getAppointmentsByPatient(patientId);
        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }

    // Obtener citas por doctor
    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<AppointmentResponse>> getAppointmentsByDoctor(@PathVariable Long doctorId) {
        List<AppointmentResponse> appointments = appointmentService.getAppointmentsByDoctor(doctorId);
        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }
}