package com.company.dishes.mapper;

import com.company.dishes.dto.OrderDtoResponse;
import com.company.dishes.model.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface OrderResponseMapper extends BaseMapper<OrderDtoResponse, OrderEntity> {
}
