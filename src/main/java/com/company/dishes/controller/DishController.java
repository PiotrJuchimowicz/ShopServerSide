package com.company.dishes.controller;

import com.company.dishes.dto.DishDto;
import com.company.dishes.service.BaseService;
import com.company.dishes.service.DishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/dishes")
@Slf4j
public class DishController extends BaseController<DishDto> {

    @Autowired
    public DishController(BaseService<DishDto> service) {
        super(service);
    }

    @GetMapping(path = "/order/{id}")
    public List<DishDto> readByOrder(@PathVariable("id") Long orderId) {
        log.info("Getting dishes of order with id: " + orderId);
        return this.getDishService().readByOrder(orderId);
    }

    @GetMapping(path = "/byRestaurantId")
    public  List<DishDto> readByRestaurantId(@RequestParam(name = "restaurantId") Long restaurantId){
        log.info("Getting dishes by restaurant id: " + restaurantId);
        return this.getDishService().readByRestaurantId(restaurantId);
    }

    @PostMapping
    public DishDto create(@Valid @RequestBody DishDto dto) {
        log.info("Creating new object: " + dto);
        return this.getService().create(dto);
    }

    public DishService getDishService() {
        return (DishService) this.getService();
    }
}
