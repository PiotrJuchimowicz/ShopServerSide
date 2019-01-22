package com.company.dishes.service;

import com.company.dishes.dto.BaseDto;

import java.util.List;

public interface BaseService<D extends BaseDto> {
    List<D> readAll();

    D read(Long id);

    D create(D dto);
}
