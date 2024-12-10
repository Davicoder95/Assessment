package com.riwi.assestment2.application.dtos.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DoctorRequestDto {
    @NotNull
    private UserRequestDto request;

    @NotNull(message = "Speciality required!")
    private String speciality;
}
