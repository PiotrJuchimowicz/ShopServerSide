package com.company.dishes.model;

import javax.persistence.*;

@Entity
@Table(name = "dish_t_order_t")
public class DishOrderEntity extends BaseEntity {
    private Long quantity;
    @ManyToOne
    @JoinColumn(name = "dish_id")
    private DishEntity dishEntity;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity orderEntity;
}
