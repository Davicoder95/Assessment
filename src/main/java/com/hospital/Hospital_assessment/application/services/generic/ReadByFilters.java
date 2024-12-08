package com.hospital.Hospital_assessment.application.services.generic;

import java.time.LocalDate;
import java.util.List;

public interface ReadByFilters<Entity> {
    public List<Entity> readByFilters(LocalDate date, String specialty, String reason);
}
