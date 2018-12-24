package com.company.dishes.mapper;

import com.company.dishes.dto.UserDto;
import com.company.dishes.model.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface UserMapper extends BaseMapper<UserDto, UserEntity> {

    void updateUserWithoutOrders(UserDto dto, @MappingTarget UserEntity entity);
}
