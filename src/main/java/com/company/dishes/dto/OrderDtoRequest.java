package com.company.dishes.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class OrderDtoRequest {
    @NotNull
    private String longitude;
    @NotNull
    private String latitude;
    @NotNull
    private Long userId;
    private List<DishDto> dishDtos;
}
