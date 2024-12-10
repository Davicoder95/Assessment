package com.riwi.assestment2.application.dtos.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthRequestDto {
    @NotBlank(message = "Identifier required")
    private String identifier;

    @NotBlank(message = "Password cannot be blank")
    private String password;
}
