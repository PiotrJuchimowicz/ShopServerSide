package com.company.dishes.mapper;

import com.company.dishes.dto.DishDto;
import com.company.dishes.model.DishEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface DishMapper extends BaseMapper<DishDto, DishEntity> {
}
