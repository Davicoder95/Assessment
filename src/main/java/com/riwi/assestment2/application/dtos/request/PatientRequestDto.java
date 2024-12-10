package com.riwi.assestment2.application.dtos.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientRequestDto {
    @NotNull
    private UserRequestDto request;

    @NotNull(message = "Phone required!")
    private String phone;

    @NotNull(message = "Address required!")
    private String address;
}
