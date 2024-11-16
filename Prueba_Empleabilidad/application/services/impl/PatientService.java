package com.assessment.Prueba_Empleabilidad.application.services.impl;

import com.assessment.Prueba_Empleabilidad.application.dtos.request.PatientRequest;
import com.assessment.Prueba_Empleabilidad.application.mappers.PatientMapper;
import com.assessment.Prueba_Empleabilidad.domain.entities.Patient;
import com.assessment.Prueba_Empleabilidad.domain.ports.service.IPatientService;
import com.assessment.Prueba_Empleabilidad.infrastructure.persistence.PatientRepository;
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
