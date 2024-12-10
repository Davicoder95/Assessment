package com.riwi.assestment2.domain.ports.service.crud;

public interface Update <EntityRequest, Entity, ID> {
    public Entity update(EntityRequest request, ID id);
}
