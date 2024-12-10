package com.riwi.assestment2.application.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DateResponseDto {
    private Long id;
    private PatientResponseDto patient_id;
    private DoctorResponseDto doctor_id;
    private LocalDateTime Date;
    private String status;
}
