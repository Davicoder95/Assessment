package com.riwi.assestment2.domain.ports.service.interfaces;

import com.riwi.assestment2.application.dtos.request.AuthRequestDto;
import com.riwi.assestment2.application.dtos.response.AuthResponseDto;

public interface IAuthService {
    public AuthResponseDto login (AuthRequestDto requestDto);
}
