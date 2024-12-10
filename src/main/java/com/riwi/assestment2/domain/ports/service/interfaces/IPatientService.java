package com.riwi.assestment2.domain.ports.service.interfaces;

import com.riwi.assestment2.application.dtos.request.AuthRequestDto;
import com.riwi.assestment2.application.dtos.request.PatientRequestDto;

public interface IPatientService {
    AuthRequestDto registerPatient(PatientRequestDto PatientRequestDto);
}
