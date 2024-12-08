package com.hospital.Hospital_assessment.domain.ports.service;


import com.hospital.Hospital_assessment.application.dtos.request.DoctorRequest;
import com.hospital.Hospital_assessment.domain.entities.Doctor;


import java.util.List;

public interface IDoctorService {
    Doctor registerDoctor(DoctorRequest doctorDTO);
    Doctor findDoctorById(Long id);
    List<Doctor> getAllDoctors();
}
