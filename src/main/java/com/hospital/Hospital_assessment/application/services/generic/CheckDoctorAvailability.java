package com.hospital.Hospital_assessment.application.services.generic;

import java.time.LocalDateTime;

public interface CheckDoctorAvailability {
    public boolean isAvailable(Long doctorId, LocalDateTime dateTime);
}

