package com.company.dishes.service_impl;

import com.company.dishes.dto.DishDto;
import com.company.dishes.dto.OrderDtoRequest;
import com.company.dishes.dto.OrderDtoResponse;
import com.company.dishes.mapper.BaseMapper;
import com.company.dishes.model.OrderEntity;
import com.company.dishes.repository.BaseRepository;
import com.company.dishes.repository.OrderRepository;
import com.company.dishes.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class OrderServiceImpl extends BaseServiceImpl<OrderDtoResponse, OrderEntity> implements OrderService {

    @Autowired
    public OrderServiceImpl(BaseRepository<OrderEntity> repository, BaseMapper<OrderDtoResponse, OrderEntity> mapper) {
        super(repository, mapper);
    }

    @Override
    public List<OrderDtoResponse> readByUserId(Long userId) {
        List<OrderEntity> orderEntities = getOrderRepository().findByUserId(userId);
        log.info("Found order entities: " + orderEntities);
        List<OrderDtoResponse> orderResponseDtos = this.getMapper().entitiesToDtos(orderEntities);
        log.info("Mapped to order responses: " + orderResponseDtos);
        return orderResponseDtos;
    }

    @Override
    public OrderDtoResponse create(OrderDtoRequest orderDtoRequest) {
        OrderDtoResponse response = new OrderDtoResponse();
        response.setAddress(orderDtoRequest.getAddress());
        LocalDateTime date = LocalDateTime.now();
        String orderDate;
        orderDate = "" +  date.getMonthValue();
        orderDate = orderDate + "/";
        orderDate = orderDate + date.getDayOfMonth();
        orderDate = orderDate + "/";
        orderDate = orderDate + date.getHour();
        orderDate = orderDate + "/";
        orderDate = orderDate + date.getMinute();
        response.setOrderDate(orderDate);
        Double price = 0D;
        for(DishDto dishDto : orderDtoRequest.getDishes()){
            price = price + dishDto.getPrice();
        }
        response.setPrice(price);
        return response;
    }

    private OrderRepository getOrderRepository() {
        return (OrderRepository) this.getRepository();
    }

}
