package org.example.testprogram.mapper;

import java.util.List;

public interface RequestMapper<D, E> {
    E toEntity(D d);
    E toEntityWithRefferance(D d, E e);
    List<E> toEntities(List<D> ds);
}
