package com.company.dishes.service;

import com.company.dishes.dto.DishDto;

import java.util.List;

public interface DishService extends BaseService<DishDto> {
    List<DishDto> readByOrder(Long orderId);
}
