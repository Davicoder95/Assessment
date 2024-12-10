package com.riwi.assestment2.application.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DateRequestDto {
    @NotNull(message = "Patient ID required!")
    private Long patientId;

    @NotNull(message = "Doctor ID required!")
    private Long doctorId;

    @NotNull(message = "DateTime required!")
    private LocalDateTime dateTime;

    @NotBlank(message = "Reason required!")
    private String reason;

    private String recommendations;
}
