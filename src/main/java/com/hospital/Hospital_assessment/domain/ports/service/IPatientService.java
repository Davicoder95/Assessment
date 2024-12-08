package com.hospital.Hospital_assessment.domain.ports.service;

import com.hospital.Hospital_assessment.application.dtos.request.PatientRequest;
import com.hospital.Hospital_assessment.domain.entities.Patient;

import java.util.List;

public interface IPatientService {
    Patient registerPatient(PatientRequest patientDTO);
    Patient findPatientById(Long id);
    List<Patient> getAllPatients();
}
