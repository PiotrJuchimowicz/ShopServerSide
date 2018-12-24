package com.company.dishes.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString(callSuper = true)
public class DishDto extends BaseDto {
    @NotNull
    private String name;
    @NotNull
    private Double price;
    @NotNull @DecimalMin(value = "0")
    private Integer numberOfPortions;
}
