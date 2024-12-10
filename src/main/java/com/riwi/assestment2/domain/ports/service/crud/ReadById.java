package com.riwi.assestment2.domain.ports.service.crud;

public interface ReadById <Entity, ID> {
public Entity readById(ID id);
}