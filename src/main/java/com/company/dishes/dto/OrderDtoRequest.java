package com.company.dishes.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@ToString
public class OrderDtoRequest {
    @NotNull
    private String address;
    @NotNull
    private String username;
    private List<DishDto> dishes;
}
