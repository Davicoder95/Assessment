package com.riwi.assestment2.domain.ports.service.interfaces;

import com.riwi.assestment2.application.dtos.request.UserRequestDto;
import com.riwi.assestment2.application.dtos.response.AuthResponseDto;
import com.riwi.assestment2.application.dtos.response.UserResponseDto;
import com.riwi.assestment2.domain.entities.User;
import com.riwi.assestment2.domain.enums.Roles;
import com.riwi.assestment2.domain.ports.service.crud.ReadAll;
import com.riwi.assestment2.domain.ports.service.crud.ReadById;
import com.riwi.assestment2.domain.ports.service.crud.Update;

public interface IUserService extends
        ReadAll<UserResponseDto>,
        ReadById<UserResponseDto,Long>,
        Update<UserRequestDto, User,Long> {
    AuthResponseDto register(UserRequestDto request, Roles role);
    User getEntityById(Long id);
}
