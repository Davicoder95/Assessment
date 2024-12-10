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
public class MedicalHistoryResponseDto {
    private Long id;
    private Long doctorId;
    private String doctorName;
    private String doctorPhone;
    private Long patientId;
    private String patientName;
    private LocalDateTime date;
    private String diagnosis;
    private String reasonOfDate;
}
