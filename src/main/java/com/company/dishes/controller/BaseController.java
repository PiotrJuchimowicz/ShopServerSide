package com.company.dishes.controller;

import com.company.dishes.service.BaseService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Getter
@Slf4j
public abstract class BaseController<D, T> {
    private final BaseService<D, T> service;

    protected BaseController(BaseService<D, T> service) {
        this.service = service;
    }

    @GetMapping(path = "/{id}")
    public D read(@PathVariable("id") T id) {
        log.info("Received json: " + id);
        return this.getService().read(id);
    }

}
