package com.assessment.Prueba_Empleabilidad.domain.ports.service;

import com.assessment.Prueba_Empleabilidad.application.dtos.request.DoctorRequest;
import com.assessment.Prueba_Empleabilidad.domain.entities.Doctor;

import java.util.List;

public interface IDoctorService {
    Doctor registerDoctor(DoctorRequest doctorDTO);
    Doctor findDoctorById(Long id);
    List<Doctor> getAllDoctors();
}
