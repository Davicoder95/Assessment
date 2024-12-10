package com.riwi.assestment2.application.dtos.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequestDto {
    @NotBlank(message = "First name required!")
    private String name;

    @NotBlank(message = "Document required!")
    private String document;

    @NotBlank(message = "Password required!")
    private String password;
}
