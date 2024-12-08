package com.hospital.Hospital_assessment.application.dtos.responses;


import com.hospital.Hospital_assessment.domain.enums.StatusDates;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class AppointmentResponse {
    private Long id;
    private StatusDates status;
    private String message;

}