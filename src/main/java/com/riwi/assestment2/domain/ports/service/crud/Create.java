package com.riwi.assestment2.domain.ports.service.crud;

public interface Create <EntityRequest, Entity>{
    public Entity create (EntityRequest request);
}
