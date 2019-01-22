package com.company.dishes.controller;

import com.company.dishes.dto.BaseDto;
import com.company.dishes.service.BaseService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Getter
@Slf4j
public abstract class BaseController<D extends BaseDto> {
    private final BaseService<D> service;

    protected BaseController(BaseService<D> service) {
        this.service = service;
    }

    @GetMapping(path = "/{id}")
    public D read(@PathVariable("id") Long id) {
        log.info("Received json: " + id);
        return this.getService().read(id);
    }

    @GetMapping
    public List<D> readAll() {
        log.info("Getting all objects");
        return this.getService().readAll();
    }

}
