package com.company.dishes.service;

import com.company.dishes.dto.OrderDtoRequest;
import com.company.dishes.dto.OrderDtoResponse;

import java.util.List;

public interface OrderService extends BaseService<OrderDtoResponse> {

    List<OrderDtoResponse> readByUserId(Long userId);

    OrderDtoResponse create(OrderDtoRequest orderDtoRequest);
}
