package com.hospital.Hospital_assessment.application.services.impl;



import com.hospital.Hospital_assessment.application.dtos.request.PatientRequest;
import com.hospital.Hospital_assessment.application.mappers.PatientMapper;
import com.hospital.Hospital_assessment.domain.entities.Patient;
import com.hospital.Hospital_assessment.domain.ports.service.IPatientService;
import com.hospital.Hospital_assessment.infrastructure.persistence.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PatientService implements IPatientService {

    @Autowired
    private final PatientRepository patientRepository;

    private final PatientMapper patientMapper;

    @Override
    public Patient registerPatient(PatientRequest patientDTO) {
        // Convertimos el DTO a la entidad usando el mapper
        Patient patient = patientMapper.toEntity(patientDTO);

        // Guardamos la entidad en la base de datos
        return patientRepository.save(patient);
    }

    @Override
    public Patient findPatientById(Long id) {
        // Buscamos el paciente por ID
        return patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));
    }
    @Override
    public List<Patient> getAllPatients() {
        // Obtenemos todos los pacientes y los retornamos como entidades
        return patientRepository.findAll();
    }
}
