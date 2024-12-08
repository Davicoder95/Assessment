package com.hospital.Hospital_assessment.application.services.impl;


import com.hospital.Hospital_assessment.application.dtos.request.DoctorRequest;
import com.hospital.Hospital_assessment.application.mappers.DoctorMapper;
import com.hospital.Hospital_assessment.domain.entities.Doctor;
import com.hospital.Hospital_assessment.domain.ports.service.IDoctorService;
import com.hospital.Hospital_assessment.infrastructure.persistence.DoctorRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DoctorService implements IDoctorService {

    @Autowired
    private final DoctorRepository doctorRepository;
    @Autowired
    private final DoctorMapper doctorMapper;

    @Override
    public Doctor registerDoctor(DoctorRequest doctorRequest) {
        // Usar el mapper para convertir DoctorRequest a Doctor
        Doctor doctor = doctorMapper.toEntiy(doctorRequest);
        // Guardar en el repositorio y devolver la entidad
        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor findDoctorById(Long id) {
        // Buscar el doctor por ID o lanzar excepción
        return doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found with ID: " + id));
    }

    @Override
    public List<Doctor> getAllDoctors() {
        // Obtener todos los doctores y devolver la lista
        return doctorRepository.findAll();
    }
}
