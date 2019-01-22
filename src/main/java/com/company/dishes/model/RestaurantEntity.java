package com.company.dishes.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "restaurant_t")
@Getter
@Setter
@ToString(callSuper = true, exclude = {"orderEntities", "restaurantEntities"})
public class RestaurantEntity extends BaseEntity {
    private String name;
    private String address;
    @OneToMany(mappedBy = "restaurantEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OrderEntity> orderEntities = new LinkedHashSet<>();
    @OneToMany(mappedBy = "restaurantEntities", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<RestaurantEntity> restaurantEntities = new LinkedHashSet<>();
}
