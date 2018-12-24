package com.company.dishes.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString(callSuper = true)
public class OrderDtoResponse extends BaseDto {
    private LocalDateTime orderDate;
    private String country;
    private String city;
    private String postalCode;
    private String address;
    private List<DishDto> dishes;
}
