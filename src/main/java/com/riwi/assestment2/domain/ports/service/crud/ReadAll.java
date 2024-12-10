package com.riwi.assestment2.domain.ports.service.crud;

import java.util.List;

public interface ReadAll <Entity> {
    public List<Entity> readAll();
}
