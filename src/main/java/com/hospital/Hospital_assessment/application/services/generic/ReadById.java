package com.hospital.Hospital_assessment.application.services.generic;

import java.util.Optional;

public interface ReadById<Entity, ID>{
    public Optional<Entity> readById(ID id);
}
