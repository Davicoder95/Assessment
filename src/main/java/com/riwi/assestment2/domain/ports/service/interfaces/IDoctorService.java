package com.riwi.assestment2.domain.ports.service.interfaces;

import com.riwi.assestment2.application.dtos.request.DoctorRequestDto;
import com.riwi.assestment2.application.dtos.response.AuthResponseDto;

public interface IDoctorService {
    AuthResponseDto registerDoctor(DoctorRequestDto request);
}
