package com.company.dishes.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Table(name = "order_t")
@Entity
@Getter
@Setter
@ToString(callSuper = true, exclude = "dishOrderEntities")
public class OrderEntity extends BaseEntity {
    private LocalDateTime orderDate;
    //TODO :  auto filled - converted from longitude and latitude from Android client
    private String address;

    public OrderEntity() {
        orderDate = LocalDateTime.now();
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private RestaurantEntity restaurantEntity;
    @OneToMany(mappedBy = "orderEntity", orphanRemoval = true, cascade = CascadeType.ALL)
    private Set<DishOrderEntity> dishOrderEntities = new LinkedHashSet<>();
}
