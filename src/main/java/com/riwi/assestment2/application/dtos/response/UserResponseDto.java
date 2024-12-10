package com.riwi.assestment2.application.dtos.response;

import lombok.*;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class UserResponseDto {
    private Long id;

    private String name;

    private String document;

    private String role;
}
