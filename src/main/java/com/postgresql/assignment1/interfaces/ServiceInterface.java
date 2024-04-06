package com.postgresql.assignment1.interfaces;

import java.util.List;
import java.util.Map;

public interface ServiceInterface<DtoType> {
    DtoType create(DtoType dto);

    DtoType getById(Long id);

    List<DtoType> getAll();

    DtoType update(Long id, Map<String, Object> fields);

    void delete(Long id);
}

