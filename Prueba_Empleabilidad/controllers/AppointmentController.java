package com.assessment.Prueba_Empleabilidad.controllers;

import com.assessment.Prueba_Empleabilidad.application.dtos.request.AppointmentRequest;
import com.assessment.Prueba_Empleabilidad.application.dtos.responses.AppointmentResponse;
import com.assessment.Prueba_Empleabilidad.domain.entities.Appointment;
import com.assessment.Prueba_Empleabilidad.domain.ports.service.IAppointmentService;
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
            AppointmentResponse appointmentResponse = new AppointmentResponse(null, null,null,null); // Crear la respuesta de cita vacía
            appointmentResponse.setMessage(ex.getMessage()); // Setear el mensaje de error
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