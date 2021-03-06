package com.company.dishes.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@ToString(callSuper = true)
public class OrderDtoResponse extends BaseDto {
    private String orderDate;
    private String address;
    private Double price;
}
