package com.company.dishes.service;

import com.company.dishes.dto.UserDto;

public interface UserService extends BaseService<UserDto> {

    UserDto update(UserDto dto);

    void delete(Long userId);

    boolean login(UserDto userDto);
}
