package com.assessment.Prueba_Empleabilidad.controllers;

import com.assessment.Prueba_Empleabilidad.application.dtos.request.DoctorRequest;
import com.assessment.Prueba_Empleabilidad.domain.entities.Doctor;
import com.assessment.Prueba_Empleabilidad.domain.ports.service.IDoctorService;
import java.util.List;
import com.assessment.Prueba_Empleabilidad.application.dtos.responses.DoctorResponse;
import com.assessment.Prueba_Empleabilidad.application.mappers.DoctorMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/doctors")
@AllArgsConstructor
public class DoctorController {

    @Autowired
    private final IDoctorService doctorService;
    @Autowired
    private final DoctorMapper doctorMapper;

    @PostMapping("registerDoctor")
    public ResponseEntity<DoctorResponse> registerDoctor(@RequestBody DoctorRequest doctorRequest) {
        Doctor doctor = doctorService.registerDoctor(doctorRequest);
        DoctorResponse response = doctorMapper.toResponse(doctor);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("Doctor/{id}")
    public ResponseEntity<DoctorResponse> findDoctorById(@PathVariable Long id) {
        Doctor doctor = doctorService.findDoctorById(id);
        DoctorResponse response = doctorMapper.toResponse(doctor);
        return ResponseEntity.ok(response);
    }

    @GetMapping("allDoctors")
    public ResponseEntity<List<DoctorResponse>> getAllDoctors() {
        List<Doctor> doctors = doctorService.getAllDoctors();
        List<DoctorResponse> response = doctors.stream()
                .map(doctorMapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }
}
