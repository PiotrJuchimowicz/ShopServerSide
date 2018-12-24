package com.company.dishes.controller;

import com.company.dishes.dto.UserDto;
import com.company.dishes.service.BaseService;
import com.company.dishes.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/users")
@Slf4j
public class UserController extends BaseController<UserDto, Long> {

    @Autowired
    public UserController(BaseService<UserDto, Long> service) {
        super(service);
    }

    @PostMapping
    public UserDto create(@Valid @RequestBody UserDto userDto) {
        log.info("Creating user using json: " + userDto);
        return this.getUserService().create(userDto);
    }

    @PatchMapping
    public UserDto update(@Valid @RequestBody UserDto userDto) {
        log.info("Updating user using json: " + userDto);
        return this.getUserService().update(userDto);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(Long userId) {
        log.info("Removing user with id: " + userId);
        this.getUserService().delete(userId);
    }

    public UserService getUserService() {
        return (UserService) this.getService();
    }
}
