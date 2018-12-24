package com.company.dishes.service;

import com.company.dishes.dto.UserDto;

public interface UserService extends BaseService<UserDto, Long> {

    UserDto create(UserDto dto);

    UserDto update(UserDto dto);

    void delete(Long userId);
}
