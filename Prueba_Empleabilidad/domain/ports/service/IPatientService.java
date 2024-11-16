package com.assessment.Prueba_Empleabilidad.domain.ports.service;

import com.assessment.Prueba_Empleabilidad.application.dtos.request.PatientRequest;
import com.assessment.Prueba_Empleabilidad.domain.entities.Patient;

import java.util.List;

public interface IPatientService {
    Patient registerPatient(PatientRequest patientDTO);
    Patient findPatientById(Long id);
    List<Patient> getAllPatients();
}
