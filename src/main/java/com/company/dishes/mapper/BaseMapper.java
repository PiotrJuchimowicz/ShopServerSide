package com.company.dishes.mapper;

import java.util.List;

public interface BaseMapper<D, E> {

    D entityToDto(E entity);

    E dtoToEntity(D dto);

    List<D> entitiesToDtos(List<E> entities);
}
