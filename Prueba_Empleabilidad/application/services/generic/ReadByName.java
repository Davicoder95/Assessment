package com.assessment.Prueba_Empleabilidad.application.services.generic;

public interface ReadByName<Entity, NAME>{
    public Entity readByName(NAME name);
}
