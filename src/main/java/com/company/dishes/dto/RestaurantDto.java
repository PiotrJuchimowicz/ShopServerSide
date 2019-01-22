package com.company.dishes.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class RestaurantDto extends BaseDto {
    private String name;
    private String address;
}
