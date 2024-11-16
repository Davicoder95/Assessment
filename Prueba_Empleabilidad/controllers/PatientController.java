package com.assessment.Prueba_Empleabilidad.controllers;

import com.assessment.Prueba_Empleabilidad.application.dtos.request.PatientRequest;
import com.assessment.Prueba_Empleabilidad.application.dtos.responses.PatientResponse;
import com.assessment.Prueba_Empleabilidad.application.mappers.PatientMapper;
import com.assessment.Prueba_Empleabilidad.domain.entities.Patient;
import com.assessment.Prueba_Empleabilidad.domain.ports.service.IPatientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
@AllArgsConstructor
public class PatientController {

    @Autowired
    private final IPatientService patientService;
    @Autowired
    private final PatientMapper patientMapper;

    // Endpoint para registrar un paciente
    @PostMapping("registerPatient")
    public ResponseEntity<PatientResponse> registerPatient(@RequestBody PatientRequest patientRequest) {
        Patient registeredPatient = patientService.registerPatient(patientRequest);
        PatientResponse response = patientMapper.toResponse(registeredPatient);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // Endpoint para obtener un paciente por ID
    @GetMapping("patient/{id}")
    public ResponseEntity<PatientResponse> findPatientById(@PathVariable Long id) {
        Patient patient = patientService.findPatientById(id);
        PatientResponse response = patientMapper.toResponse(patient);
        return ResponseEntity.ok(response);
    }

    // Endpoint para obtener todos los pacientes
    @GetMapping("allPatient")
    public ResponseEntity<List<PatientResponse>> getAllPatients() {
        List<Patient> patients = patientService.getAllPatients();
        List<PatientResponse> response = patients.stream()
                .map(patientMapper::toResponse)
                .toList();
        return ResponseEntity.ok(response);
    }
}
