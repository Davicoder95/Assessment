package com.hospital.Hospital_assessment.application.services.generic;

public interface ReadByName<Entity, NAME>{
    public Entity readByName(NAME name);
}
