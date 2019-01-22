package com.company.dishes.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;


@Table(name = "dish_t")
@Entity
@Getter
@Setter
@ToString(callSuper = true, exclude = "dishOrderEntities")
public class DishEntity extends BaseEntity {
    private String name;
    private Double price;
    @OneToMany(mappedBy = "dishEntity", orphanRemoval = true, cascade = CascadeType.ALL)
    private Set<DishOrderEntity> dishOrderEntities = new LinkedHashSet<>();
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private RestaurantEntity restaurantEntity;

}
