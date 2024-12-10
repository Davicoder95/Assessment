package com.riwi.assestment2.domain.ports.service.interfaces;

import com.riwi.assestment2.application.dtos.request.DateRequestDto;
import com.riwi.assestment2.application.dtos.response.DateResponseDto;
import com.riwi.assestment2.domain.entities.Date;
import com.riwi.assestment2.domain.enums.StatusDates;
import com.riwi.assestment2.domain.ports.service.crud.*;

public interface IDateService extends
    Create<DateRequestDto, Date>,
    ReadAll<DateResponseDto>,
    ReadById<DateResponseDto, Long>,
    Update<DateRequestDto, Date, Long>,
        Delete<Long> {
        Date changeStatus(StatusDates status, Long id);
}
