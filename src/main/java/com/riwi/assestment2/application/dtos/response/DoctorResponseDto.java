package com.riwi.assestment2.application.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DoctorResponseDto {
    private Long id;
    private String name;
    private String document;
    private String phone;
    private String speciality;
}
