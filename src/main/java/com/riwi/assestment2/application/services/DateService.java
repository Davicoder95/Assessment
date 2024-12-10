package com.riwi.assestment2.application.services;

import com.riwi.assestment2.application.dtos.request.DateRequestDto;
import com.riwi.assestment2.application.dtos.response.DateResponseDto;
import com.riwi.assestment2.domain.entities.Date;
import com.riwi.assestment2.domain.entities.Doctor;
import com.riwi.assestment2.domain.entities.Patient;
import com.riwi.assestment2.domain.enums.StatusDates;
import com.riwi.assestment2.domain.ports.service.interfaces.IDateService;
import com.riwi.assestment2.infrastructure.persistence.DateRepository;
import com.riwi.assestment2.infrastructure.persistence.DoctorRepository;
import com.riwi.assestment2.infrastructure.persistence.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

public class DateService implements IDateService {

    @Autowired
    private DateRepository dateRepository;
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;
    @Override
    public Date changeStatus(StatusDates status, Long id) {
        return null;
    }

    @Override
    public Date create(DateRequestDto dateRequestDto) {
        if (dateRequestDto.getDateTime().isBefore(LocalDateTime.now())){
            throw new RuntimeException("Date must be in the future");
        }
        Patient patient = patientRepository.findById(dateRequestDto.getPatientId()).get();
        Doctor doctor = doctorRepository.findById(dateRequestDto.getDoctorId()).get();


        return null;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public List<DateResponseDto> readAll() {
        return List.of();
    }

    @Override
    public DateResponseDto readById(Long aLong) {
        return null;
    }

    @Override
    public Date update(DateRequestDto dateRequestDto, Long aLong) {
        return null;
    }
}
