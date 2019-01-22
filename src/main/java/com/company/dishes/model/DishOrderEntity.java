package com.company.dishes.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "dish_t_order_t")
public class DishOrderEntity extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "dish_id")
    private DishEntity dishEntity;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity orderEntity;
}
