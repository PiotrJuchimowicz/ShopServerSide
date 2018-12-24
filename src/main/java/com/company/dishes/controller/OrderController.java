package com.company.dishes.controller;

import com.company.dishes.dto.OrderDtoRequest;
import com.company.dishes.dto.OrderDtoResponse;
import com.company.dishes.service.BaseService;
import com.company.dishes.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/orders")
@Slf4j
public class OrderController extends BaseController<OrderDtoResponse, Long> {

    @Autowired
    public OrderController(BaseService<OrderDtoResponse, Long> service) {
        super(service);
    }

    @PostMapping
    public OrderDtoResponse create(@Valid @RequestBody OrderDtoRequest orderDtoRequest) {
        log.info("Creating order using json: " + orderDtoRequest);
        return this.getOrderService().create(orderDtoRequest);
    }

    @GetMapping(path = "/user/{id}")
    public List<OrderDtoResponse> readByUserId(@PathVariable("id") Long userId) {
        log.info("Getting orders of user with id: " + userId);
        return this.getOrderService().readByUserId(userId);
    }

    public OrderService getOrderService() {
        return (OrderService) this.getService();
    }


}
