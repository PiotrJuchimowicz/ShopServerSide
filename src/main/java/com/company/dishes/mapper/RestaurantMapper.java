package com.company.dishes.mapper;

import com.company.dishes.dto.RestaurantDto;
import com.company.dishes.model.RestaurantEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface RestaurantMapper extends BaseMapper<RestaurantDto, RestaurantEntity> {
}
