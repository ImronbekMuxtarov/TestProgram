package org.example.testprogram.mapper;

import java.util.List;

public interface ResponseMapper<D, E> {
    D toDTO(E e);
    List<D> toDTOs(List<E> es);
}
