package com.company.dishes.controller;

import com.company.dishes.dto.DishDto;
import com.company.dishes.service.BaseService;
import com.company.dishes.service.DishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/dishes")
@Slf4j
public class DishController extends BaseController<DishDto, Long> {

    @Autowired
    public DishController(BaseService<DishDto, Long> service) {
        super(service);
    }

    @GetMapping(path = "/order/{id}")
    public List<DishDto> readByOrder(@PathVariable("id") Long orderId) {
        log.info("Getting dishes of order with id: " + orderId);
        return this.getDishService().readByOrder(orderId);
    }

    public DishService getDishService() {
        return (DishService) this.getService();
    }
}
