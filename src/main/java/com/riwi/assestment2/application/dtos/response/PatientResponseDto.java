package com.riwi.assestment2.application.dtos.response;

import com.riwi.assestment2.domain.entities.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientResponseDto {
    private Long id;
    private String name;
    private String document;
    private String phone;
    private String address;
    private List<Date> dates;
}
