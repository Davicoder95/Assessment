package com.hospital.Hospital_assessment.application.services.generic;

public interface Create<Entity, EntityRequest> {
    public Entity create(EntityRequest entityRequest);
}
