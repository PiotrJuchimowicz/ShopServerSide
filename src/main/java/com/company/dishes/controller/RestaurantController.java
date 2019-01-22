package com.company.dishes.controller;

import com.company.dishes.dto.RestaurantDto;
import com.company.dishes.service.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/restaurants")
@Slf4j
public class RestaurantController extends BaseController<RestaurantDto> {
    @Autowired
    public RestaurantController(BaseService<RestaurantDto> service) {
        super(service);
    }

    @PostMapping
    public RestaurantDto create(@Valid @RequestBody RestaurantDto dto) {
        log.info("Creating new object: " + dto);
        return this.getService().create(dto);
    }
}
