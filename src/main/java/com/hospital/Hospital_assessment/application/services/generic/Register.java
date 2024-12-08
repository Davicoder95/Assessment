package com.hospital.Hospital_assessment.application.services.generic;

public interface Register<Entity, EntityRequest> {
    public Entity register(EntityRequest entityRequest);
}
